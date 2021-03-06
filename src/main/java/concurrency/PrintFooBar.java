package concurrency;

import java.util.concurrent.Semaphore;

/**
 * Suppose you are given the following code:
 * <p>
 * class FooBar {
 * public void foo() {
 * for (int i = 0; i < n; i++) {
 * print("foo");
 * }
 * }
 * <p>
 * public void bar() {
 * for (int i = 0; i < n; i++) {
 * print("bar");
 * }
 * }
 * }
 * The same instance of FooBar will be passed to two different threads. Thread A will call foo() while thread B will call bar(). Modify the given program to output "foobar" n times.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: n = 1
 * Output: "foobar"
 * Explanation: There are two threads being fired asynchronously. One of them calls foo(), while the other calls bar(). "foobar" is being output 1 time.
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: "foobarfoobar"
 * Explanation: "foobar" is being output 2 times.
 */
public class PrintFooBar {
  private final int n;
  private final Semaphore s1 = new Semaphore(1);
  private final Semaphore s2 = new Semaphore(0);

  public PrintFooBar(int n) {
    this.n = n;
  }

  public void foo(Runnable printFoo) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      s1.acquire();
      printFoo.run();
      s2.release();
    }
  }

  public void bar(Runnable printBar) throws InterruptedException {
    for (int i = 0; i < n; i++) {
      s2.acquire();
      printBar.run();
      s1.release();
    }
  }
}
