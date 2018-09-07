/**
 * The MIT License
 * Copyright (c) 2018 Anshul Mohil
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.interview.coding.problems;

/**
 * In DNA strings, symbols 'A' and 'T' are complements of each other, as are
 * 'C' and 'G'. Given a nucleotide p, we denote its complementary nucleotide as
 * p. The reverse complement of a DNA string Pattern = p1…pn is the string
 * Pattern* = pn* … p1* formed by taking the complement of each nucleotide in
 * Pattern, then reversing the resulting string.
 * <p>
 * For example, the reverse complement of Pattern = "GTCA" is Pattern* = "TGAC".
 */

/**
 * REVERSE COMPLEMENT PROBLEM
 * <p>
 * Find the reverse complement of a DNA string.
 * <p>
 * Given:  A DNA string Pattern.
 * Return: Pattern*, the reverse complement of Pattern.
 */
public class ReverseComplementProblem {
  /**
   * @param args none
   */
  public static void main(String[] args) {
    // DEFINE "dna"!!!
    String dna = "";
    // DEFINE "dna"!!!

    System.out.println(reverseComplement(dna));
  }

  /**
   * @param dna dna
   * @return reverse complement of passed dna
   */
  public static String reverseComplement(String dna) {
    String out = "";
    for (int i = dna.length() - 1; i >= 0; --i) {
      char curr = dna.charAt(i);
      if (curr == 'A') {
        out += 'T';
      } else if (curr == 'T') {
        out += 'A';
      } else if (curr == 'C') {
        out += 'G';
      } else if (curr == 'G') {
        out += 'C';
      } else {
        System.out.println("ERROR: Input is not a DNA Sequence.");
        System.exit(-1);
      }
    }
    return out;
  }
} 
