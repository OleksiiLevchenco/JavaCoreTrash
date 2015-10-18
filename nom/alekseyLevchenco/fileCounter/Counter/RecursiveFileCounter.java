package nom.alekseyLevchenco.fileCounter.Counter;


import nom.alekseyLevchenco.fileCounter.Main;
import nom.alekseyLevchenco.fileCounter.ResultLine;

import java.io.File;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CountDownLatch;


/**
 * @author Alexey Levchenko
 */
public class RecursiveFileCounter implements FileCounter, Callable<ResultLine> ,Runnable {

    private final String path;
    private List<ResultLine> results;
    private CountDownLatch latch;
    private CallBack callBack;

    public RecursiveFileCounter(String path, CountDownLatch latch, CallBack callBack) {
        this.path = path;
        this.latch = latch;
        this.callBack = callBack;
    }

    @Override
    public int count(String path) throws InterruptedException {
        Thread.sleep(250);
        int amount = 0;
        File[] files = new File(path).listFiles();
        if (files != null) {
            for (File file : files) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("counter canceled");
                    throw new InterruptedException();
                }
                if (file.isFile()) {
                    amount++;
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        System.out.println("counter canceled");
                        throw new InterruptedException();
                    }
                } else { // is folder
                    try {
                        Thread.sleep(250);
                    } catch (InterruptedException e) {
                        System.out.println("counter canceled");
                        throw new InterruptedException();
                    }
                    amount += count(file.getPath());
                }
            }
        } else {
            return -1;
        }
        return amount;
    }



//    public void run() {
//        try {
//            result.add(new ResultLine(path, count(path)));
//            latch.countDown();
//            System.out.println(latch.getCount());
//        } catch (InterruptedException e) {
//            System.out.println("catch counters interrupted");
//            return;
//        }
//    }

    @Override
    public ResultLine call() throws Exception {
        return new ResultLine(path, count(path));
    }

    @Override
    public void run() {
        try {
//            results.add(new ResultLine(path, count(path)));
            callBack.collBack(new ResultLine(path, count(path)));
            latch.countDown();
        } catch (InterruptedException nothing) {}
    }
}
