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

import java.util.Scanner;

/**
 * Visa2
 */
public class Visa2 {

  /**
   * @param args none
   * @throws Exception scanner related
   */
  public static void main(String[] args) throws Exception {
    Scanner sc = new Scanner(System.in);

    int lines = sc.nextInt();

    //String[] inputs = new String[lines];
    for (int i = 0; i <= lines; i++) {
      String input = sc.next();
      if ((input.length() % 2) != 0) {
        System.out.println("-1");
        continue;
      }
      final int mid = input.length() / 2;
      String[] parts = {input.substring(0, mid), input.substring(mid)};

      System.out.println(countManipulations(parts[0], parts[1]));
    }
    sc.close();
  }

  /**
   * @param s1 string1
   * @param s2 string2
   * @return manipulation count
   */
  public static int countManipulations(String s1, String s2) {
    int count = 0;
    int[] charcount = new int[26];
    for (int i = 0; i < s1.length(); i++) {
      charcount[s1.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length(); i++) {
      if (charcount[s2.charAt(i) - 'a']-- <= 0) {
        count++;
      }
    }
    return count;
  }
}
