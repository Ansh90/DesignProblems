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
   * @return
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
