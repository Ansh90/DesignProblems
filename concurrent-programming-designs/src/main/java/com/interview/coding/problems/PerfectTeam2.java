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
