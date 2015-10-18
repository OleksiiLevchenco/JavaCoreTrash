package nom.alekseyLevchenco.fileCounter.Counter;

import nom.alekseyLevchenco.fileCounter.FullResultList;
import nom.alekseyLevchenco.fileCounter.Main;
import nom.alekseyLevchenco.fileCounter.ResultLine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author Alexey Levchenko
 */
public class FileCountingService implements CallBack<ResultLine> {
    FullResultList results = new FullResultList();
    ExecutorService executorService = Executors.newCachedThreadPool();
    CountDownLatch latch;

    public FileCountingService() {
    }

    private FullResultList executeEx(List<String> folders) {
        latch = new CountDownLatch(folders.size());
        for (String folder : folders) {
            executorService.execute(new RecursiveFileCounter(folder, latch, this));
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            executorService.shutdownNow();
            this.results.setFull(false);
            return this.results;
        }
        results.setFull(true);
        return this.results;
    }

    public FullResultList getResults(List<String> folders) {
        return executeEx(folders);
    }

    @Override
    public void collBack(ResultLine r) {
        results.add(r);
    }

    public void shutdown() {
        executorService.shutdownNow();
    }
}
