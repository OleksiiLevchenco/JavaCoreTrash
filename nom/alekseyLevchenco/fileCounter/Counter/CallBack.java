package nom.alekseyLevchenco.fileCounter.Counter;

import nom.alekseyLevchenco.fileCounter.ResultLine;

/**
 * @author Alexey Levchenko
 */
public interface CallBack<T> {
    void collBack(T t);
}
