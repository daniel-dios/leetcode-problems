package concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * Suppose you are given the following code:
 * <p>
 * class ZeroEvenOdd {
 * public ZeroEvenOdd(int n) { ... }      // constructor
 * public void zero(printNumber) { ... }  // only output 0's
 * public void even(printNumber) { ... }  // only output even numbers
 * public void odd(printNumber) { ... }   // only output odd numbers
 * }
 * The same instance of ZeroEvenOdd will be passed to three different threads:
 * <p>
 * Thread A will call zero() which should only output 0's.
 * Thread B will call even() which should only ouput even numbers.
 * Thread C will call odd() which should only output odd numbers.
 * Each of the threads is given a printNumber method to output an integer. Modify the given program to output the series 010203040506... where the length of the series must be 2n.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 2
 * Output: "0102"
 * Explanation: There are three threads being fired asynchronously. One of them calls zero(), the other calls even(), and the last one calls odd(). "0102" is the correct output.
 * Example 2:
 * <p>
 * Input: n = 5
 * Output: "0102030405"
 */
public class ZeroEvenOdd {
  private final int n;
  private final Semaphore zero = new Semaphore(1);
  private final Semaphore odd = new Semaphore(0);
  private final Semaphore pair = new Semaphore(0);

  public ZeroEvenOdd(int n) {
    this.n = n;
  }

  // printNumber.accept(x) outputs "x", where x is an integer.
  public void zero(IntConsumer printNumber) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      zero.acquire();

      printNumber.accept(0);

      odd.release();
      pair.release();
    }
  }

  public void even(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i++) {
      pair.acquire();

      if (i % 2 == 0) {
        printNumber.accept(i);
        zero.release();
      }
    }
  }

  public void odd(IntConsumer printNumber) throws InterruptedException {
    for (int i = 1; i <= n; i++) {
      odd.acquire();

      if (i % 2 == 1) {
        printNumber.accept(i);
        zero.release();
      }
    }
  }
}
