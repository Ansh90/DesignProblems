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
package com.designpatterns.singleton;

/**
 * LazyInitializationSingleton
 */
public final class LazyInitializationSingleton {

  private static LazyInitializationSingleton lazyInitializationSingleton;

  private LazyInitializationSingleton() {
  }

  /**
   * Double checking machanism helps when multiple theads wait to acquire synchronized block.
   *
   * @return instance
   */
  public static LazyInitializationSingleton getInstance() {
    if (lazyInitializationSingleton == null) {
      synchronized (LazyInitializationSingleton.class) {
        if (lazyInitializationSingleton == null) {
          lazyInitializationSingleton = new LazyInitializationSingleton();
        }
      }
    }
    return lazyInitializationSingleton;
  }
}
