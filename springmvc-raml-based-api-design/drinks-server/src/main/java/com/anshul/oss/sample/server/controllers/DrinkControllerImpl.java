/**
 * The MIT License
 * Copyright (c) 2018 Anshul Mohil
 * <p>
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * <p>
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * <p>
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.anshul.oss.sample.server.controllers;

import com.anshul.oss.sample.server.exceptions.DrinkNotFoundException;
import com.anshul.oss.sample.server.models.AbstractDrink;
import com.anshul.oss.sample.server.models.AlcoholicDrink;
import com.anshul.oss.sample.server.models.SoftDrink;
import com.anshul.oss.sample.server.models.enums.DrinkTypeEnum;
import com.anshul.oss.sample.server.rest.DrinkController;
import com.anshul.oss.sample.server.rest.model.CreateDrinkRequest;
import com.anshul.oss.sample.server.rest.model.GetDrinkByIdResponse;
import com.anshul.oss.sample.server.rest.model.GetDrinksResponse;
import com.anshul.oss.sample.server.rest.model.UpdateDrinkByIdRequest;
import com.anshul.oss.sample.server.services.DrinksServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Delegate implementation of the DrinkController for use by the generated endpoint
 * controller
 */
@Component
public class DrinkControllerImpl implements DrinkController {

  private static final Logger LOG = LoggerFactory.getLogger(DrinkController.class);
  @Autowired
  private DrinksServiceInterface drinksService;

  @Override
  public ResponseEntity<List<GetDrinksResponse>> getDrinks() {
    List<GetDrinksResponse> getDrinksResponse = new ArrayList<GetDrinksResponse>();
    List<AbstractDrink> drinks = this.drinksService.getDrinks();

    //map each drink to an appropriate response object
    for (AbstractDrink drink : drinks) {
      GetDrinksResponse drinkReponse = new GetDrinksResponse();
      drinkReponse.setName(drink.getName());
      drinkReponse.setType(drink.getDrinkTypeEnum().name());
      getDrinksResponse.add(drinkReponse);
    }

    LOG.info("Returning list of {} available drinks ... ", getDrinksResponse.size());
    return new ResponseEntity<List<GetDrinksResponse>>(getDrinksResponse, HttpStatus.OK);
  }

  @Override
  public ResponseEntity createDrink(CreateDrinkRequest createDrinkRequest) {
    LOG.debug("Entered createDrink endpoint");
    try {
      DrinkTypeEnum drinkType = DrinkTypeEnum.valueOf(String.valueOf(createDrinkRequest.getType()));
      AbstractDrink drink = null;
      switch (drinkType) {
        case ALCOHOL:
          drink = new AlcoholicDrink(createDrinkRequest.getName());
          break;
        case SOFT_DRINK:
          drink = new SoftDrink(createDrinkRequest.getName());
          break;
        default:
          LOG.error("Incorrect drink type passed: [{}] ", createDrinkRequest.getType());
          return new ResponseEntity(HttpStatus.BAD_REQUEST);
      }
      this.drinksService.addDrink(drink);
      LOG.info("Returning from createDrink");
      return new ResponseEntity(HttpStatus.ACCEPTED);
    } catch (DrinkNotFoundException dex) {
      return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

  }

  @Override
  public ResponseEntity<GetDrinkByIdResponse> getDrinkById(String drinkName) {
    GetDrinkByIdResponse getDrinkByIdResponse = new GetDrinkByIdResponse();

    try {
      AbstractDrink drink = this.drinksService.getDrink(drinkName);
      getDrinkByIdResponse.setName(drink.getName());
      getDrinkByIdResponse.setType(drink.getDrinkTypeEnum().name());
      LOG.info("Returning from getDrinkById");
      return new ResponseEntity<GetDrinkByIdResponse>(getDrinkByIdResponse, HttpStatus.OK);
    } catch (DrinkNotFoundException e) {
      return new ResponseEntity<GetDrinkByIdResponse>(HttpStatus.NOT_FOUND);
    }
  }

  @Override
  public ResponseEntity updateDrinkById(String drinkName, UpdateDrinkByIdRequest updateDrinkByIdRequest) {
    try {
      this.drinksService.modifyDrink(drinkName.toLowerCase(), updateDrinkByIdRequest.getName());
      LOG.info("Returning from updateDrinkById");
      return new ResponseEntity(HttpStatus.OK);
    } catch (DrinkNotFoundException dex) {
      return new ResponseEntity<GetDrinkByIdResponse>(HttpStatus.NOT_FOUND);
    }

  }

  @Override
  public ResponseEntity deleteDrinkById(String drinkName) {
    try {
      this.drinksService.deleteDrink(drinkName);
      LOG.info("Returning from deleteDrinkById");
      return new ResponseEntity(HttpStatus.ACCEPTED);
    } catch (DrinkNotFoundException dex) {
      return new ResponseEntity<GetDrinkByIdResponse>(HttpStatus.NOT_FOUND);
    }
  }
}
