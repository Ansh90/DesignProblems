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
package com.multithreading.designpattern.common;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Supplier;

/**
 * CompletableFuture implements CompletionStage and Future interface.
 * Which means CompletableFuture have methods related to Both the above
 * interfaces along with some extra methods.
 * CompletionStage helps to chain multiple tasks which should run
 * one after another.
 */
public class CompletableStageAPI {


  /**
   * ObtrudeValue(Value)  this should be used in error recovery.
   * value returned will be passed value.
   * complete(Value) this can be used in normal execution.
   * value returned either passed value or actual returned value
   * of a task if at all it completes successfully.
   * <p>
   * Note: Value is an object whoes type dependent on type of
   * object stored in CompletableFuture object stored by
   * returned task.
   * <p>
   * <p>
   * completeExceptionally(Throwable)
   * if task is not done yet then it will force the task to be done
   * in exceptional way, ie. get() or join() will throw exception
   * post that if not already completed.
   * <p>
   * obtrudeException(Throwable)
   * if task is done or not done it will force the task to be
   * completed exceptionally. Thrown exception won't be passed
   * exception. passed exception can be seen as a root cause
   * of the final exception thrown.
   * <p>
   * <p>
   * <p>
   * Note: CompletableFuture use jvm fork/pool which have all
   * the demon threads. So that means if you are running any
   * task on that pool it must be service task and if it is
   * not then you better pass executor created poll run your
   * task using CompletableFuture.
   * <p>
   * in contrast Executor pool is of non-demon threads so if
   * you do not shutdown thread pool it won't exit at all.
   * <p>
   * join() and get() are the blocking calls, if done on
   * non-demon thread it will prevent non-demon thread from
   * exiting until completion and inturn keep the demon
   * threads alive.
   * <p>
   * Note: diff between get() and join() is get throws
   * checked exception where as join() throws unchecked
   * exception.
   *
   * @param args
   */
  public static void main(String[] args) {
    Supplier<String> supplier = () -> {
      String resultStr = " From Supplier " + Thread.currentThread().getName();
      System.out.println(resultStr);
      return resultStr;
    };

    CompletableFuture<List<String>> stringCompletableFuture = CompletableFuture.supplyAsync(
        () -> {
          List l = new ArrayList<>();
          l.add(1L);
          l.add(2L);
          l.add(3L);
          return l;
        }, Executors.newFixedThreadPool(4));


  }

  private static void usageOfCompletableFuture() {
    Runnable runnable = () -> {
      System.out.println("From runnable task " + Thread.currentThread().getName());
    };


    ExecutorService executorService = Executors.newFixedThreadPool(5);

    // CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(runnable,executorService);
    CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(runnable);
    voidCompletableFuture.join();

    Supplier<String> supplier = () -> {
      String resultStr = " From Supplier " + Thread.currentThread().getName();
      System.out.println(resultStr);
      return resultStr;
    };

    CompletableFuture<String> stringCompletableFuture = CompletableFuture.supplyAsync(supplier, executorService);
    String result = stringCompletableFuture.join();

    /**
     * Note: Value is an object whoes type dependent on type of
     * object stored in CompletableFuture object stored by
     * returned task.
     */
    stringCompletableFuture.complete("Taking too long");

    System.out.println(result + " HE");
  }
}
