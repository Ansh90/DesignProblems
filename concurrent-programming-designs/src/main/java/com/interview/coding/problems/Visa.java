package com.interview.coding.problems;

import java.util.*;

public class Visa {

  public static void main(String[] args) {
    List<String> l = new LinkedList<>();
    l.add("4 2");
    l.add("2 4");
    l.add("2 4");
    l.add("2 3");
    String s = sum(l);
    System.out.println(s);
  }

  static String sum(List<String> abvalues) {

    List<Integer> num = new LinkedList<>();
    List<Integer> den = new LinkedList<>();

    Iterator<String> itr = abvalues.iterator();
    while (itr.hasNext()) {
      String s = itr.next();
      String[] num_den = s.split(" ");
      num.add(Integer.valueOf(num_den[0]));
      den.add(Integer.valueOf(num_den[1]));
    }
	  if (num.size() != den.size()) {
		  return "";
	  }
    int gcd = 0;
    // for i in xrange(0, len(den)-1):


    return null;

  }

  static int gcd(int a, int b) {
    // Everything divides 0
	  if (a == 0 || b == 0) {
		  return 0;
	  }

    // base case
	  if (a == b) {
		  return a;
	  }

    // a is greater
	  if (a > b) {
		  return gcd(a - b, b);
	  }
    return gcd(a, b - a);
  }

  private static int lcm(int a, int b) {
    return a * b;
  }

  private static int lcmm(int n1, int n2) {
    int lcm;
    lcm = (n1 > n2) ? n1 : n2;

    // Always true
    while (true) {
      if (lcm % n1 == 0 && lcm % n2 == 0) {
        //  System.out.printf("The LCM of %d and %d is %d.", n1, n2, lcm);
        return lcm;
        //  break;
      }
      ++lcm;
    }

  }

//	   def lcmm(self, *args):
//	      """Return lcm of args."""   
//	      return reduce(self.lcm, args)    

}
//
// #parameter num, a list of numerator
// #parameter den, a list of denominator
// def ration_sum(self, num, den):
//
// if len(num) != len(den):
//
// print "The length of numerators is not equal to denominators"
// return
//
// #find the gratest common factor for denominators
// gcd = 0
// for i in xrange(0, len(den)-1):
//
// gcd = self.gcd(den[i], den[i+1])
//
// #find the least common multiple for denominators
// lcm = self.lcmm(*den)
//
// num_sum = 0 #initialize the sum of num
//
// for i in xrange(0, len(num)):
// num_sum += num[i] * (lcm/den[i])
//
// gcd_sum = self.gcd(num_sum, lcm) #greatest common factor of sum num and den
//
// return num_sum/gcd_sum, lcm/gcd_sum


//// Counts the no of manipulations required
//public static int countManipulations(String s1, String s2)
//{
//		if ((s1.length() % 2) != 0)
//        return -1;
//		
//    int count = 0;
//
//    // store the count of character
//    int char_count[] = new int[26];
//
//    // iterate though the first String and update 
//    // count
//    for (int i = 0; i < s1.length(); i++) 
//        char_count[s1.charAt(i) - 'a']++;        
//
//    // iterate through the second string
//    // update char_count.
//    // if character is not found in char_count
//    // then increase count
//    for (int i = 0; i < s2.length(); i++) 
//        if (char_count[s2.charAt(i) - 'a']-- <= 0)
//            count++;
//    return count;
//}