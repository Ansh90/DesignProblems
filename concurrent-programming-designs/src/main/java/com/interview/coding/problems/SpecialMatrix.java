package com.interview.coding.problems;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * SpecialMatrix
 */
public class SpecialMatrix {

  int currentMax = Integer.MIN_VALUE;
  int currentMin = Integer.MAX_VALUE;

  /**
   * @param args none
   */
  public static void main(String[] args) {
    List<Integer> l1 = new LinkedList<>();
    l1.add(1);
    l1.add(3);
    l1.add(4);
    List<Integer> l2 = new LinkedList<>();
    l2.add(5);
    l2.add(2);
    l2.add(9);
    List<Integer> l3 = new LinkedList<>();
    l3.add(8);
    l3.add(7);
    l3.add(6);

    List<List<Integer>> finalList = new LinkedList<>();
    finalList.add(l1);
    finalList.add(l2);
    finalList.add(l3);
  }

  public static int countSpecialElements(List<List<Integer>> matrix) {

    int finalVal = 0;
    int row_len = matrix.size();
    int col_len = matrix.get(0).size();
    for (int row = 0; row < row_len; row++) {
      for (int col = 0; col < col_len; col++) {
        int currentVal = matrix.get(row).get(col);
        if ((isMaxInRow(matrix, row, currentVal) && isMaxInCol(matrix, col, currentVal))
            || (isMinInRow(matrix, row, currentVal) && isMinInCol(matrix, col, currentVal))) {
          finalVal = -1;
        } else if (isMaxInRow(matrix, row, currentVal)) {
          finalVal += 1;
        } else if (isMaxInRow(matrix, col, currentVal)) {
          finalVal += 1;
        }
      }
    }
    return finalVal;
  }

  private static boolean isMaxInRow(List<List<Integer>> matrix, int rowIndex, int currentVal) {
    return Collections.max(matrix.get(rowIndex)) == currentVal;
  }

  private static boolean isMinInRow(List<List<Integer>> matrix, int rowIndex, int currentVal) {
    return Collections.min(matrix.get(rowIndex)) == currentVal;
  }

  private static boolean isMaxInCol(List<List<Integer>> matrix, int colIndex, int currentVal) {
    for (int i = 0; i < matrix.get(0).size(); i++) {
      if (currentVal < matrix.get(i).get(colIndex)) {
        return false;
      }
    }
    return true;
  }

  private static boolean isMinInCol(List<List<Integer>> matrix, int colIndex, int currentVal) {
    for (int i = 0; i < matrix.get(0).size(); i++) {
      if (currentVal > matrix.get(i).get(colIndex)) {
        return false;
      }
    }
    return true;
  }

}
