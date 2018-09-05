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

import java.util.Collections;
import java.util.HashMap;

/**
 * PerfectTeam2
 */
public class PerfectTeam2 {

  /**
   * @param skills skills
   * @return max pools
   */
  public static int abc(String skills) {

    HashMap<Character, Integer> skillMap = new HashMap<>();

    for (Character skill : skills.toCharArray()) {
      if (skillMap.containsKey(skill)) {
        skillMap.put(skill, skillMap.get(skill) + 1);
      } else {
        skillMap.put(skill, 1);
      }
    }
    if (skillMap.keySet().size() == 5) {
      return Collections.min(skillMap.values());
    } else {
      return 0;
    }
  }
}
