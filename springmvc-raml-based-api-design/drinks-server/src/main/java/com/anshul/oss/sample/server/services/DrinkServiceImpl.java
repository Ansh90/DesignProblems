/**
 * The MIT License
 * Copyright (c) 2018 Anshul Mohil
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.anshul.oss.sample.server.services;

import com.anshul.oss.sample.server.exceptions.DrinkNotFoundException;
import com.anshul.oss.sample.server.models.AbstractDrink;
import com.anshul.oss.sample.server.models.AlcoholicDrink;
import com.anshul.oss.sample.server.models.SoftDrink;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Simple service layer performing CRUD tasks on an in-memory map of POJOs.
 */
@Component
public class DrinkServiceImpl implements DrinksServiceInterface {

  private final static Logger LOG = LoggerFactory.getLogger(DrinkServiceImpl.class);
  private Map<String, AbstractDrink> drinks;

  public DrinkServiceImpl() {
    LOG.debug("Initializing drinks dispenser... ");

    //initialize drinks array
    drinks = new HashMap<String, AbstractDrink>();

    drinks.put("fanta", new SoftDrink("Fanta"));
    drinks.put("cocacola", new SoftDrink("CocaCola"));
    drinks.put("martini", new AlcoholicDrink("Martini"));
    drinks.put("vodka", new AlcoholicDrink("Vodka"));

    LOG.debug("Initialized drinks dispenser with {} items", drinks.size());
  }

  @Override
  public void modifyDrink(String oldName, String newName) throws DrinkNotFoundException {
    LOG.info("Modifying drink with name [{}] to [{}] ...", oldName, newName);
    if (drinks.containsKey(oldName.toLowerCase())) {
      LOG.debug("Successfully found drink with name [{}]. Changing drink name to [{}]...", oldName, newName);
      AbstractDrink drink = drinks.get(oldName.toLowerCase());
      drink.setName(newName);
      drinks.put(newName.toLowerCase(), drink);
      drinks.remove(oldName.toLowerCase());
      LOG.debug("Successfully completed name change for drink with name [{}]!", newName);
    } else {
      LOG.error("Failed to find drink with name: [{}]");
      throw new DrinkNotFoundException("Could not find drink with name " + oldName);
    }
  }

  @Override
  public void addDrink(AbstractDrink drink) throws DrinkNotFoundException {
    LOG.info("Adding drink with name: [{}] and type: [{}]", drink.getName(), drink.getDrinkTypeEnum().name());
    if (!drinks.containsKey(drink.getName().toLowerCase())) {
      drinks.put(drink.getName().toLowerCase(), drink);
      LOG.debug("Drink [{}] has been successfuly created!", drink.getName());
    } else {
      LOG.warn("Drink name already exists!");
      throw new DrinkNotFoundException("Drink already exists");
    }

  }

  @Override
  public void deleteDrink(String name) throws DrinkNotFoundException {
    LOG.info("Deleting drink with name: [{}]", name);
    if (drinks.containsKey(name.toLowerCase())) {
      drinks.remove(name.toLowerCase());
      LOG.debug("Successfully deleted [{}]", name);
    } else {
      LOG.error("[{}] could not be found!", name);
      throw new DrinkNotFoundException("Drink not found!");
    }
  }

  @Override
  public List<AbstractDrink> getDrinks() {
    LOG.info("Retrieving list of available drinks ... ");
    return new ArrayList<AbstractDrink>(this.drinks.values());
  }

  @Override
  public AbstractDrink getDrink(String name) throws DrinkNotFoundException {
    LOG.info("Retrieving details for [{}] ...", name);
    if (drinks.containsKey(name.toLowerCase())) {
      LOG.debug("Found drink with name: [{}]. Returning details ... ", name);
      return this.drinks.get(name.toLowerCase());
    } else {
      LOG.error("Could not find drink with name: [{}]", name);
      throw new DrinkNotFoundException("Failed to find drink with name : " + name);
    }
  }

}
