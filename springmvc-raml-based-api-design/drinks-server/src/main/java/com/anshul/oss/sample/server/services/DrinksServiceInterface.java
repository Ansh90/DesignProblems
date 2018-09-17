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
package com.anshul.oss.sample.server.services;

import com.anshul.oss.sample.server.exceptions.DrinkNotFoundException;
import com.anshul.oss.sample.server.models.AbstractDrink;

import java.util.List;

/**
 * DrinksServiceInterface
 */
public interface DrinksServiceInterface {

  /**
   * Adds a drink to the list
   *
   * @param drink describes the drink's details
   * @throws DrinkNotFoundException
   */
  void addDrink(AbstractDrink drink) throws DrinkNotFoundException;

  /**
   * Retrieves the full list of available drinks
   *
   * @return arraylist of available drinks
   */
  List<AbstractDrink> getDrinks();


  /**
   * Retrieves a specific drink
   *
   * @param name the name of the drink
   * @return the details about the drink
   * @throws DrinkNotFoundException
   */
  AbstractDrink getDrink(String name) throws DrinkNotFoundException;

  /**
   * Modifies the name of a drink
   *
   * @param oldName the old name of the drink
   * @param newName the new name of the drink
   * @throws DrinkNotFoundException
   */
  void modifyDrink(String oldName, String newName) throws DrinkNotFoundException;

  /**
   * @param name
   * @throws DrinkNotFoundException
   */
  void deleteDrink(String name) throws DrinkNotFoundException;
}
