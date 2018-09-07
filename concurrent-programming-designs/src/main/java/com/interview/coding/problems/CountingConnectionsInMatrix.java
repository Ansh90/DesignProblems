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

import java.util.List;

/**
 * CountingConnectionsInMatrix
 */
public class CountingConnectionsInMatrix {

  /**
   * @param arr input matrix
   * @return max count
   */
  public static int countConnections(List<List<Integer>> arr) {

    int rowLen = arr.size();
    int colLen = arr.get(0).size();
    int finalConnections = 0;

    for (int row = 0; row < rowLen; row++) {
      for (int col = 0; col < colLen; col++) {
        if (arr.get(row).get(col) == 1) {
          if (col + 1 < colLen && arr.get(row).get(col + 1) == 1) {
            finalConnections += 1;
          }
          if ((row + 1) < rowLen && arr.get(row + 1).get(col) == 1) {
            finalConnections += 1;
          }
          if ((row + 1) < rowLen && (col + 1) < colLen && arr.get(row + 1).get(col + 1) == 1) {
            finalConnections += 1;
          }
          if ((row + 1) < rowLen && (col - 1) >= 0 && arr.get(row + 1).get(col - 1) == 1) {
            finalConnections += 1;
          }
        }
      }
    }
    return finalConnections;
  }
}
