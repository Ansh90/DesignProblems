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

//Find the total area covered by two rectilinear rectangles in a 2D plane.
//
//Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.
//
//    https://leetcode.com/static/images/problemset/rectangle_area.png
//
//
//
//Rectangle Area
//
//Example:
//
//Input: A = -3, B = 0, C = 3, D = 4, E = 0, F = -1, G = 9, H = 2
//Output: 45
//Note:
//
//Assume that the total area is never beyond the maximum possible value of int.


/**
 * OverLappingRectangle
 */
public class OverLappingRectangle {

  /**
   *
   * all parameters are co-ordinates
   * @param a a
   * @param b b
   * @param c c
   * @param d d
   * @param e e
   * @param f f
   * @param g g
   * @param h h
   * @return final overlapped area
   */
  public int computeArea(int a, int b, int c, int d, int e, int f, int g, int h) {

    int areaOfSqrA = (c - a) * (d - b);
    int areaOfSqrB = (g - e) * (h - f);

    int left = Math.max(a, e);
    int right = Math.min(g, c);
    int bottom = Math.max(f, b);
    int top = Math.min(d, h);

    //If overlap
    int overlap = 0;
    if (right > left && top > bottom) {
      overlap = (right - left) * (top - bottom);
    }

    return areaOfSqrA + areaOfSqrB - overlap;
  }
}
