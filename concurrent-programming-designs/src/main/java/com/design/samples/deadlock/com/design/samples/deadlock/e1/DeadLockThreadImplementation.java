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
package com.design.samples.deadlock.com.design.samples.deadlock.e1;

/**
 *
 */
public class DeadLockThreadImplementation implements Runnable {
  /**
   * Demonstration of deadlock
   * <p>
   * This class holds 2 objects both have only synchronized
   * methods. Which means they can only be accessed sequentially.
   * Now I have done their implementations as such that they call
   * each other internally to each other. If 2 theads calls
   * resourceAObject and resourceBObject concurrently they will
   * go for deadlock as both threads have locks over current thread
   * and racing to achieve lock over other dependent thread.
   */

  private ResourceAObject resourceAObject = new ResourceAObject();
  private ResourceBObject resourceBObject = new ResourceBObject();

  public void run() {
    resourceBObject.updateCurrentFromResource(resourceAObject);
  }

  /**
   *
   */
  public void directMethod() {
    DeadLockThreadImplementation deadLockEntryPoint = new DeadLockThreadImplementation();
    Thread thread = new Thread(deadLockEntryPoint);
    thread.start();

    resourceAObject.updateCurrentFromResource(resourceBObject);
  }
}
