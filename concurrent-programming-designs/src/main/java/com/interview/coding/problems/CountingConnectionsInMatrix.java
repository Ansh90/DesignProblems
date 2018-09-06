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

    int row_len = arr.size();
    int col_len = arr.get(0).size();
    int finalConnections = 0;

    for (int row = 0; row < row_len; row++) {
      for (int col = 0; col < col_len; col++) {
        if (arr.get(row).get(col) == 1) {
          if (col + 1 < col_len && arr.get(row).get(col + 1) == 1) {
            finalConnections += 1;
          }
          if ((row + 1) < row_len && arr.get(row + 1).get(col) == 1) {
            finalConnections += 1;
          }
          if ((row + 1) < row_len && (col + 1) < col_len && arr.get(row + 1).get(col + 1) == 1) {
            finalConnections += 1;
          }
          if ((row + 1) < row_len && (col - 1) >= 0 && arr.get(row + 1).get(col - 1) == 1) {
            finalConnections += 1;
          }
        }
      }
    }
    return finalConnections;
  }
}
