package nom.alekseyLevchenco.fileCounter.Counter;


import nom.alekseyLevchenco.fileCounter.ResultLine;

import java.util.concurrent.Callable;

/**
 * @author Alexey Levchenko
 */
public interface FileCounter extends Callable<ResultLine> {
     int count(String path) throws InterruptedException;
}
