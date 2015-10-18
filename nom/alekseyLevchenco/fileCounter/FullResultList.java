package nom.alekseyLevchenco.fileCounter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author Alexey Levchhenko
 */
public class FullResultList implements Iterable<ResultLine> {
    private boolean full = false;
    private List<ResultLine> resultLineList = Collections.synchronizedList(new ArrayList<ResultLine>());

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    public List<ResultLine> getResultLineList() {
        return resultLineList;
    }

    public void setResultLineList(List<ResultLine> resultLineList) {
        this.resultLineList = resultLineList;
    }


    @Override
    public Iterator<ResultLine> iterator() {
        return resultLineList.iterator();
    }

    public void add(ResultLine r){
        this.resultLineList.add(r);
    }

    public ResultLine get(int index) {
        return this.resultLineList.get(index);
    }

}
