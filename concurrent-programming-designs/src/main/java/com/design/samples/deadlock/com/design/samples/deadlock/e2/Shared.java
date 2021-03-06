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
package com.design.samples.deadlock.com.design.samples.deadlock.e2;

/**
 * This class is shared by both threads
 */
class Shared {
  /**
   * first synchronized method
   *
   * @param s2 shared object
   */
  synchronized void test1(Shared s2) {
    System.out.println("test1-begin");
    Util.sleep(100);

    // taking object lock of s2 enters
    // into test2 method
    s2.test2(this);
    System.out.println("test1-end");
  }

  /**
   * second synchronized method
   *
   * @param s1 shared object
   */
  synchronized void test2(Shared s1) {
    System.out.println("test2-begin");
    Util.sleep(100);

    // taking object lock of s1 enters
    // into test1 method
    s1.test1(this);
    System.out.println("test2-end");
  }
}
