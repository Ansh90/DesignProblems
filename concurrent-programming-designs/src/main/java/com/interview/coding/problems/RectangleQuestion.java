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

    int k = Math.max(k, p);
    int l = Math.max(l, q);
    int m = Math.min(m, r);
    int n = Math.min(n, s);
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
