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
 * AsyncExampleMultiBranchEither
 */
public class AsyncExampleMultiBranchEither {

  /**
   * @param args none
   */
  public static void main(String[] args) {

    ExecutorService executor1 = Executors.newSingleThreadExecutor();

    Supplier<List<Long>> supplyIDs = () -> {
      sleep(200);
      return Arrays.asList(1L, 2L, 3L);
    };
    /**
     * Function R, T here input type R is List Long
     * and return would be CompletableFuture of user List
     */
    Function<List<Long>, CompletableFuture<List<User>>> fetchUsers1 = ids -> {
      sleep(150);
      Supplier<List<User>> userSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
      return CompletableFuture.supplyAsync(userSupplier);
    };

    Function<List<Long>, CompletableFuture<List<User>>> fetchUsers2 = ids -> {
      sleep(5000);
      Supplier<List<User>> userSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
      return CompletableFuture.supplyAsync(userSupplier);
    };

    Consumer<List<User>> displayer = users -> users.forEach(System.out::println);

    CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);

    CompletableFuture<List<User>> users1 = completableFuture.thenComposeAsync(fetchUsers1);

    CompletableFuture<List<User>> users2 = completableFuture.thenComposeAsync(fetchUsers2);

    users1.thenRun(() -> System.out.println("Users 1"));
    users2.thenRun(() -> System.out.println("Users 2"));

    users1.acceptEither(users2, displayer);


    Function<List<Long>, List<User>> fetchUsers3 = ids -> {
      sleep(5000);
      Supplier<List<User>> userSupplier = () -> ids.stream().map(User::new).collect(Collectors.toList());
      return userSupplier.get();
    };
    /**
     * Accept example
     */
    CompletableFuture<List<Long>> listCompletableFuture = CompletableFuture.supplyAsync(supplyIDs);
    listCompletableFuture.thenApplyAsync(fetchUsers3).thenAcceptAsync(displayer);


    sleep(6_000);
    executor1.shutdown();
  }

  private static void sleep(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
