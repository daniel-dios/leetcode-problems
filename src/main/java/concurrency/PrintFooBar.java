package concurrency;

import java.util.concurrent.Semaphore;

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
