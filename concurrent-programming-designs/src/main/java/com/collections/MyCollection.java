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

package com.collections;

import java.util.Iterator;

/**
 * Basic collection implementation
 *
 * @param <T> Type of collection.
 */
public class MyCollection<T> implements Iterable<T> {

  private volatile T[] object;
  private volatile int nElem = 0;

  public MyCollection(int size) {
    this.object = (T[]) new Object[size];
  }

  public int size() {
    return nElem;
  }

  /**
   * @param val value to add in collection
   */
  public void add(T val) {
    synchronized (this) {
      this.object[nElem++] = val;
    }
  }

  /**
   * @param val value to remove
   * @return value which it removed as null.
   */
  public T remove(T val) {
    for (int i = 0; i < size(); i++) {
      if (val.equals(object[i])) {
        synchronized (this) {
          nElem--;
          return removeAndMove(object, i);
        }
      }
    }
    return null;
  }

  private T removeAndMove(T[] object, int i) {
    T temp;
    if (i == size()) {
      temp = object[i];
      object[i] = null;
      return temp;
    }
    temp = object[i];
    for (int idx = i; i < size(); i++) {
      object[idx] = object[idx + 1];
    }

    return temp;
  }

  public T get(int i) {
    return object[i];
  }

  public Iterator<T> iterator() {
    return new MyIterator();
  }

  private class MyIterator implements Iterator<T> {

    private volatile int index = 0;

    public boolean hasNext() {
      return index < size();
    }

    public T next() {
      return get(index++);
    }

    public void remove() {
      throw new UnsupportedOperationException("not supported yet");

    }
  }
}
