package com.interview.coding.problems;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class Visa2 {

  public static void main(String args[]) throws Exception {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT */
    //BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
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

      //System.out.println(parts[0]); //first part
      // System.out.println(parts[1]); //second part
      System.out.println(countManipulations(parts[0], parts[1]));
    }
    sc.close();
  }

  public static int countManipulations(String s1, String s2) {
    int count = 0;

    // store the count of character
    int char_count[] = new int[26];

    // iterate though the first String and update
    // count
	  for (int i = 0; i < s1.length(); i++) {
		  char_count[s1.charAt(i) - 'a']++;
	  }

    // iterate through the second string
    // update char_count.
    // if character is not found in char_count
    // then increase count
	  for (int i = 0; i < s2.length(); i++) {
		  if (char_count[s2.charAt(i) - 'a']-- <= 0) {
			  count++;
		  }
	  }
    return count;
  }
}
