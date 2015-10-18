package nom.alekseyLevchenco.fileCounter.TestWaitInterruption;

import java.util.concurrent.CountDownLatch;

/**
 * @author Alexey Levchhenko
 */
public class Worker implements Runnable{
    private static int count = 0;
    private int workerId = count++;
    CountDownLatch latch;

    public Worker(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.println("Worker "+workerId+" started" );
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            System.out.println("Worker "+workerId+ " interrupted");
            return;
        }

        System.out.println("Worker "+workerId+" finish" );
        latch.countDown();

    }
}
