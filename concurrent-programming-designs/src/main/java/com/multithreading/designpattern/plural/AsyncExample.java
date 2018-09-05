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
package com.multithreading.designpattern.plural;

import com.multithreading.designpattern.plural.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

/**
 *
 */
public class AsyncExample {

  /**
   * @param args command line arguments expected
   */
  public static void main(String[] args) {

    ExecutorService executor1 = Executors.newSingleThreadExecutor();
    ExecutorService executor2 = Executors.newSingleThreadExecutor();

    Supplier<List<Long>> supplyIDs = () -> {
      sleep(200);
      return Arrays.asList(1L, 2L, 3L);
    };


    Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
      sleep(300);
      System.out.println("Function is currently running in " + Thread.currentThread().getName());
      Supplier<List<User>> userSupplier =
          () -> {
            System.out.println("Currently running in " + Thread.currentThread().getName());
            return ids.stream().map(User::new).collect(Collectors.toList());
          };
      return CompletableFuture.supplyAsync(userSupplier, executor2);
    };

    Consumer<List<User>> displayer = users -> {
      System.out.println("Running in " + Thread.currentThread().getName());
      users.forEach(System.out::println);
    };

    CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);

    completableFuture.thenComposeAsync(fetchUsers, executor2)
        .thenAcceptAsync(displayer, executor1);

    sleep(1_000);
    executor1.shutdown();
    executor2.shutdown();
  }

  private static void sleep(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}
