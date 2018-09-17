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
package com.anshul.oss.sample.main;


import com.phoenixnap.oss.sample.client.DrinkClient;
import com.phoenixnap.oss.sample.client.HealthCheckClient;
import com.phoenixnap.oss.sample.client.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * ClientRunner
 */
@Component
public class ClientRunner
    implements CommandLineRunner {

  private static final Logger LOG = LoggerFactory.getLogger(ClientRunner.class);

  @Autowired
  HealthCheckClient hcClient;

  @Autowired
  DrinkClient drinkClient;

  /**
   * {@inheritDoc}}
   */
  @SuppressWarnings("rawtypes")
  @Override
  public void run(String... args)
      throws Exception {
    //checks health of endpoint
    ResponseEntity<GetHealthCheckResponse> healthCheck = hcClient.getHealthCheck();
    assertTrue("Health check failed! Server is not healthy.", healthCheck.getStatusCode().equals(HttpStatus.OK));
    LOG.info("Health Check status : {}", healthCheck.getStatusCode());

    //get list of drinks (GET list)
    ResponseEntity<List<GetDrinksResponse>> getDrinksResponse = drinkClient.getDrinks();
    assertTrue("Failed to perform GET request.", getDrinksResponse.getStatusCode().equals(HttpStatus.OK));
    getDrinksResponse.getBody().forEach(d -> LOG.info(d.getName() + ","));

    //get specific drink (GET)
    ResponseEntity<GetDrinkByIdResponse> drink = drinkClient.getDrinkById("Martini");
    assertTrue("Failed to perform GET request.", drink.getStatusCode().equals(HttpStatus.OK));

    //output all details returned
    LOG.info("Drink name: [{}]", drink.getBody().getName());
    LOG.info("Drink type: [{}]", drink.getBody().getType());

    //create drink (POST)
    CreateDrinkRequest createDrinkRequest = new CreateDrinkRequest();
    createDrinkRequest.setName("Wine");
    createDrinkRequest.setType("ALCOHOL");
    ResponseEntity createDrinkResponse = drinkClient.createDrink(createDrinkRequest);
    assertTrue("Failed to perform POST request.", createDrinkResponse.getStatusCode().equals(HttpStatus.ACCEPTED));
    LOG.info("Successfully created drink with name [{}]", createDrinkRequest.getName());

    //update drink (PUT)
    UpdateDrinkByIdRequest updateDrinkByIdRequest = new UpdateDrinkByIdRequest();
    updateDrinkByIdRequest.setName("Beer");
    ResponseEntity updateResponse = drinkClient.updateDrinkById("wine", updateDrinkByIdRequest);
    assertTrue("Failed to perform PUT request.", updateResponse.getStatusCode().equals(HttpStatus.OK));
    LOG.info("Successfully updated drink. Verifying ...");

    //Verify update
    ResponseEntity<GetDrinkByIdResponse> updatedDrink = drinkClient.getDrinkById(updateDrinkByIdRequest.getName());
    boolean responseOK = updatedDrink.getStatusCode().equals(HttpStatus.OK) && updatedDrink.getBody() != null;
    assertTrue("Failed to verify PUT request. Failed to update drink", responseOK);
    LOG.info("Successfully verified drink update!");

    //delete drink (DELETE)
    ResponseEntity deleteResponse = drinkClient.deleteDrinkById(updateDrinkByIdRequest.getName());
    assertTrue("Failed perform DELETE request.", deleteResponse.getStatusCode().equals(HttpStatus.ACCEPTED));
    LOG.info("Successfully deleted drink with name: [{}]", updateDrinkByIdRequest.getName());
  }
}
