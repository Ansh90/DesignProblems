package com.anshul.async.method.invocation;

import java.util.Optional;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ExecutorPoolAsync implements AsyncExecutor {

  private final AtomicInteger atomicInteger = new AtomicInteger();


  /**
   * Now to become executorpool async, i need to implement thread pool.
   */
  @Override
  public <T> AsyncResult<T> startProcess(Callable<T> task) {
    return startProcess(task, null);
  }

  /**
   * Each call to startProcess will trigger task on new thread whose future
   * result proxy would be passed immediate but actual data will be calculated
   * and filled in <code>AsyncResult</code> later in some point in time.
   *
   * @param task     task to be executed asynchronously
   * @param callback callback to be executed on task completion
   * @param <T>
   * @return
   */
  @Override
  public <T> AsyncResult<T> startProcess(Callable<T> task, AsyncCallback<T> callback) {

    CompletableFuture<T> completableFuture = new CompletableFuture(callback);
    new Thread(() -> {
      try {
        completableFuture.setValue(task.call());
      } catch (Exception ex) {
        completableFuture.setException(ex);
      }
    }, "executor number : " + atomicInteger.getAndIncrement()).start();
    return completableFuture;
  }

  /**
   * This is a blocking call on asyncResult object if, object does not have
   * result yet it will block current thread and wait to <code>AsyncResult</code>
   * to be filled.
   *
   * @param asyncResult async result of a task
   * @param <T>         type provided at startProcess calling time
   * @return T value inside of future object
   * @throws ExecutionException
   * @throws InterruptedException
   */
  @Override
  public <T> T get(AsyncResult<T> asyncResult) throws ExecutionException, InterruptedException {
    if (!asyncResult.isCompleted()) {
      asyncResult.await();
    }
    return asyncResult.getValue();
  }


//

  /**
   * Simple implementation of async result that allows completing it successfully with a value
   * or exceptionally with an exception.
   * <p>
   * <p>
   * Notice: Setter methods
   * are not coming from interface
   * as AsyncResult is an contract to access future objects.
   * Since adding data/exception is internal operations exposing
   * them as API would make setter methods fix to interface and impossible
   * to change in order to provide backward compatibility.
   * <p>
   * Crux: Only expose required methods.
   *
   * @param <T>
   */
  private static final class CompletableFuture<T> implements AsyncResult {

    static final Status status = Status.RUNNING;
    private Lock lock = new ReentrantLock(true);

    private Optional<AsyncCallback<T>> callback;

    public CompletableFuture(AsyncCallback<T> callback) {
      this.callback = Optional.ofNullable(callback);
    }

    @Override
    public boolean isCompleted() {
      return false;
    }

    @Override
    public Object getValue() throws ExecutionException {

      return null;
    }

    private <T> CompletableFuture<T> setValue(T value) {
      return null;
    }

    @Override
    public void await() throws InterruptedException {

    }

    public void setException(Exception ex) {
      System.out.println();
    }

    private enum Status {
      COMPLETED(3), FAILED(2), RUNNING(1);

      private int statusVal;

      Status(int val) {
        this.statusVal = val;
      }

      public int getStatusVal() {
        return statusVal;
      }
    }
  }
}
// public static void main(String args[]) {
//    // let's print name of each enum and there action
//    // - Enum values() examples
//    Status[] signals = Status.values();
//
//    for (Status signal : signals) {
//      // use getter method to get the value
//      System.out.println("name : " + signal.name() +
//          " action: " + signal.getStatusVal());
//    }
//  }