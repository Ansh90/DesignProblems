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
package com.interview.coding.problems;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Visa
 */
public class Visa {

  /**
   * @param args none
   */
  public static void main(String[] args) {
    List<String> l = new LinkedList<>();
    l.add("4 2");
    l.add("2 4");
    l.add("2 4");
    l.add("2 3");
    String s = sum(l);
    System.out.println(s);
  }

  /**
   * @param abvalues abvalues
   * @return sum
   */
  static String sum(List<String> abvalues) {

    List<Integer> num = new LinkedList<>();
    List<Integer> den = new LinkedList<>();

    Iterator<String> itr = abvalues.iterator();
    while (itr.hasNext()) {
      String s = itr.next();
      String[] numDen = s.split(" ");
      num.add(Integer.valueOf(numDen[0]));
      den.add(Integer.valueOf(numDen[1]));
    }
    if (num.size() != den.size()) {
      return "";
    }
    int gcd = 0;
    // for i in xrange(0, len(den)-1):


    return null;

  }

  static int gcd(int a, int b) {
    // Everything divides 0
    if (a == 0 || b == 0) {
      return 0;
    }

    // base case
    if (a == b) {
      return a;
    }

    // a is greater
    if (a > b) {
      return gcd(a - b, b);
    }
    return gcd(a, b - a);
  }

  private static int lcm(int a, int b) {
    return a * b;
  }

  private static int lcmm(int n1, int n2) {
    int lcm;
    lcm = (n1 > n2) ? n1 : n2;

    // Always true
    while (true) {
      if (lcm % n1 == 0 && lcm % n2 == 0) {
        //  System.out.printf("The LCM of %d and %d is %d.", n1, n2, lcm);
        return lcm;
        //  break;
      }
      ++lcm;
    }
  }
}