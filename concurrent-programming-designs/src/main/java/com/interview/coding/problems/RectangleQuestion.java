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

/**
 * RectangleQuestion
 */
public class RectangleQuestion {

  /**
   * @param k k
   * @param l l
   * @param m m
   * @param n n
   * @param p p
   * @param q q
   * @param r r
   * @param s s
   * @return value
   */
  public static int solution(int k, int l, int m, int n, int p, int q, int r, int s) {
    // write your code in Java SE 8

    int areaFirstRect = Math.abs(m - k) * Math.abs(l - n);
    int areaSecondRect = Math.abs(r - p) * Math.abs(q - s);
    int totalArea = areaFirstRect + areaSecondRect;

    boolean isoverlap = true;

//    int k = Math.max(k, p);
//    int l = Math.max(l, q);
//    int m = Math.min(m, r);
//    int n = Math.min(n, s);
    int areaklmn = Math.abs(m - k) * Math.abs(l - n);
    if (k > r || l > s || m < p || n < q) {
      isoverlap = false;
    }
    if (isoverlap) {
      return totalArea - areaklmn;
    } else {
      return totalArea;
    }
  }
}
