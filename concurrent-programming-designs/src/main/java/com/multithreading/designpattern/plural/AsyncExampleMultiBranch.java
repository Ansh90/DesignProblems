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

import com.multithreading.designpattern.plural.model.Email;
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
 * CompletableStage demonstration samples
 *
 */
public class AsyncExampleMultiBranch {

  /**
   *  Entry point method for AsyncExample
   * @param args not expecting any command line input
   */
  public static void main(String[] args) {

    ExecutorService executor1 = Executors.newSingleThreadExecutor();

    Supplier<List<Long>> supplyIDs = () -> {
      sleep(200);
      return Arrays.asList(1L, 2L, 3L);
    };


    Function<List<Long>, CompletableFuture<List<User>>> fetchUsers = ids -> {
      sleep(250);
      Supplier<List<User>> userSupplier =
          () -> ids.stream().map(User::new).collect(Collectors.toList());
      return CompletableFuture.supplyAsync(userSupplier);
    };

    Function<List<Long>, CompletableFuture<List<Email>>> fetchEmails = ids -> {
      sleep(350);
      Supplier<List<Email>> userSupplier =
          () -> ids.stream().map(Email::new).collect(Collectors.toList());
      return CompletableFuture.supplyAsync(userSupplier);
    };

    /**
     * Consumer<List<User>> displayer = users -> users.forEach(System.out::println);
     */



    CompletableFuture<List<Long>> completableFuture = CompletableFuture.supplyAsync(supplyIDs);

    /**
     * Note: thenAccept() to chain consumer
     * thenRun() to chain runnable task
     * thenApply() to chain Function
     */

    CompletableFuture<List<User>> userFuture = completableFuture.thenCompose(fetchUsers);
    CompletableFuture<List<Email>> emailFuture = completableFuture.thenCompose(fetchEmails);

    userFuture.thenAcceptBoth(
        emailFuture,
        (users, emails) -> {
          int i = 0;
          for (User user : users) {
            System.out.println(" sending email to " + user.getId() + " email: " + emails.get(i++));
          }
          System.out.println(users.size() + " - " + emails.size());
        });

    sleep(1_000);
    executor1.shutdown();
  }

  private static void sleep(int timeout) {
    try {
      Thread.sleep(timeout);
    } catch (InterruptedException e) {
      System.out.println(e.getMessage());
    }
  }
}
