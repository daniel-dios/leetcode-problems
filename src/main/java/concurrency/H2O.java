package concurrency;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class H2O {
  private final CyclicBarrier barrier = new CyclicBarrier(3);
  private final Semaphore hydro = new Semaphore(2);
  private final Semaphore oxy = new Semaphore(1);

  public H2O() {

  }

  public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
    try {
      hydro.acquire();
      barrier.await();
      // releaseHydrogen.run() outputs "H". Do not change or remove this line.
      releaseHydrogen.run();
    } catch (BrokenBarrierException | InterruptedException ex) {
      // for barrier
    } finally {
      hydro.release();
    }

  }

  public void oxygen(Runnable releaseOxygen) throws InterruptedException {
    try {
      oxy.acquire();
      barrier.await();
      // releaseOxygen.run() outputs "O". Do not change or remove this line.
      releaseOxygen.run();
    } catch (BrokenBarrierException | InterruptedException ex) {
      // for barrier
    } finally {
      oxy.release();
    }
  }
}
