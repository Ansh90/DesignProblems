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
package com.interview.coding.problems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * SpecialMatrix
 */
public class SpecialMatrix {

  int currentMax = Integer.MIN_VALUE;
  int currentMin = Integer.MAX_VALUE;

  /**
   * @param args none
   */
  public static void main(String[] args) {
    List<Integer> l1 = new LinkedList<>();
    l1.add(1);
    l1.add(3);
    l1.add(4);
    List<Integer> l2 = new LinkedList<>();
    l2.add(5);
    l2.add(2);
    l2.add(9);
    List<Integer> l3 = new LinkedList<>();
    l3.add(8);
    l3.add(7);
    l3.add(6);

    List<List<Integer>> finalList = new LinkedList<>();
    finalList.add(l1);
    finalList.add(l2);
    finalList.add(l3);
    int finalCount = countSpecialElements(finalList);
    System.out.println(finalCount);
  }

  /**
   *
   * @param matrix 2D array
   * @return count
   */
  public static int countSpecialElements(List<List<Integer>> matrix) {

    int finalVal = 0;
    int rowLen = matrix.size();
    int colLen = matrix.get(0).size();
    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        int currentVal = matrix.get(row).get(col);
        if ((isMaxInRow(matrix, row, currentVal) && isMaxInCol(matrix, col, currentVal))
            || (isMinInRow(matrix, row, currentVal) && isMinInCol(matrix, col, currentVal))) {
          finalVal = -1;
        } else if (isMaxInRow(matrix, row, currentVal)) {
          finalVal += 1;
        } else if (isMaxInRow(matrix, col, currentVal)) {
          finalVal += 1;
        }
      }
    }
    return finalVal;
  }

  private static boolean isMaxInRow(List<List<Integer>> matrix, int rowIndex, int currentVal) {
    return Collections.max(matrix.get(rowIndex)) == currentVal;
  }

  private static boolean isMinInRow(List<List<Integer>> matrix, int rowIndex, int currentVal) {
    return Collections.min(matrix.get(rowIndex)) == currentVal;
  }

  private static boolean isMaxInCol(List<List<Integer>> matrix, int colIndex, int currentVal) {
    for (int i = 0; i < matrix.get(0).size(); i++) {
      if (currentVal < matrix.get(i).get(colIndex)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isMinInCol(List<List<Integer>> matrix, int colIndex, int currentVal) {
    for (int i = 0; i < matrix.get(0).size(); i++) {
      if (currentVal > matrix.get(i).get(colIndex)) {
        return false;
      }
    }
    return true;
  }

}
