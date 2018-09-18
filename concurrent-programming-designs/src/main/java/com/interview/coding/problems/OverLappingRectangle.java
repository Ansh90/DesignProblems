package com.interview.coding.problems;

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
