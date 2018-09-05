package com.interview.coding.problems;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class PerfectTeam2 {
//	def my_func(self, skills):
//
//        skill_dict = {}
//
//        for skill in skills:
//
//            if skill in skill_dict:
//
//                skill_dict[skill] += 1
//
//            else:
//
//                skill_dict[skill] = 1 
//
//
//
//        if len(skill_dict) == 5:
//
//            return min(skill_dict.values())
//
//        else:
//
//            return 0


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
