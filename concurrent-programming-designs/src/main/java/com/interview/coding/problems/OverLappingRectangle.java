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
   * @param A a
   * @param B b
   * @param C c
   * @param D d
   * @param E e
   * @param F f
   * @param G g
   * @param H h
   * @return final overlapped area
   */
  public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int areaOfSqrA = (C-A) * (D-B);
         int areaOfSqrB = (G-E) * (H-F);

        int left = Math.max(A, E);
        int right = Math.min(G, C);
        int bottom = Math.max(F, B);
        int top = Math.min(D, H);

        //If overlap
        int overlap = 0;
        if(right > left && top > bottom)
             overlap = (right - left) * (top - bottom);

        return areaOfSqrA + areaOfSqrB - overlap;
    }
}
