package com.interview.coding.problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * RectangleQuestion
 */
public class RectangleQuestion {

  /**
   * @param K k
   * @param L l
   * @param M m
   * @param N n
   * @param P p
   * @param Q q
   * @param R r
   * @param S s
   * @return value
   */
  public static int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
    // write your code in Java SE 8

    int areaFirstRect = Math.abs(M - K) * Math.abs(L - N);
    int areaSecondRect = Math.abs(R - P) * Math.abs(Q - S);
    int totalArea = areaFirstRect + areaSecondRect;

    boolean isoverlap = true;

    int k = Math.max(K, P);
    int l = Math.max(L, Q);
    int m = Math.min(M, R);
    int n = Math.min(N, S);
    int areaklmn = Math.abs(m - k) * Math.abs(l - n);
    if (K > R || L > S || M < P || N < Q) {
      isoverlap = false;
    }

    if (isoverlap) {
      return totalArea - areaklmn;
    } else {
      return totalArea;
    }
  }

//  /**
//   *
//   * @param A none expected
//   */
//	public static void main(String[] A) {
//
//		System.out.println(solution(-4, 1, 2, 6, 0, -1, 4, 3));
//
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		int k=10;
//		for (int i = 0; i < A.length; i++) {
//			map.merge( K - A[i], 1, Integer::sum);
//		}
//		return Arrays.stream(A).map(element -> map.getOrDefault(element, 0)).sum();
//	}
}
