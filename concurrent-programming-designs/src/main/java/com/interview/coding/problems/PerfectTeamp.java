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

import java.util.Scanner;

/**
 * PerfectTeamp
 */
public class PerfectTeamp {

  /**
   * @param args none
   */
  public static void main(String[] args) {
    /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    Scanner input = new Scanner(System.in);
    int n = input.nextInt();
    int m = input.nextInt();

    String[] skills = new String[n];
    int maxSkills = 0;
    int maxSkillTeams = 0;
    input.nextLine(); //advances the past the first line of input integers

    for (int i = 0; i < n; i++) {
      skills[i] = input.nextLine();
    }


    for (int i = 0; i < n; i++) {
      for (int j = i + 1; j < n; j++) {
        String member1 = skills[i];
        String member2 = skills[j];
        int skillSet = 0;

        for (int k = 0; k < m; k++) {
          if (member1.charAt(k) == '1' || member2.charAt(k) == '1') {
            skillSet++;
          }
        }

        maxSkillTeams += (maxSkills == skillSet) ? 1 : 0;

        if (skillSet > maxSkills) {
          maxSkillTeams = 1;
          maxSkills = skillSet;
        }
      }
    }
    System.out.println(maxSkills + "\n" + maxSkillTeams);
  }
} 
