package nom.alekseyLevchenco.fileCounter.TestWaitInterruption;

import nom.alekseyLevchenco.fileCounter.Interrupter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Alexey Levchhenko
 */
public class Waiter implements Runnable {
    private ExecutorService executorService = Executors.newCachedThreadPool();
    private CountDownLatch latch = new CountDownLatch(5);
    private Thread interrupter = new Thread(new Interrupter());
    @Override
    public void run() {
        for (int i = 0; i<5; i++) {
            executorService.execute(new Worker(latch));
        }
        executorService.shutdown();
        Interrupter inter = new Interrupter();

        inter.addThreadToInterruption(Thread.currentThread());
        interrupter = new Thread(inter);
        interrupter.setDaemon(true);
        interrupter.start();
        try {
            latch.await();
            System.out.println("Waiter are interrupted!");
        } catch (InterruptedException e) {
            if (latch.getCount()>0){
                System.out.println("Waiter are interrupted! for kill " + latch.getCount());
                executorService.shutdownNow();
                return;
            }
            if (latch.getCount() == 0) {
                System.out.println("Waiter are interrupted! latch = " + latch.getCount());
            }
        }
        System.out.println("Waiter are interrupted! job is done " + latch.getCount());

    }
}
