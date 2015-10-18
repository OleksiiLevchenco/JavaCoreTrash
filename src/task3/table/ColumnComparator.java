package task3.table;

import java.util.Comparator;
import java.util.Map;

/**
 * @author Alexey Levchenko
 */
public class ColumnComparator implements Comparator<Map<String,Comparable>> {
    String key;

    public ColumnComparator(String key) {
        this.key = key;
    }

    @Override
    public int compare(Map<String, Comparable> o1, Map<String, Comparable> o2) {
        return  (o1.get(key).compareTo(o2.get(key)));
    }
}
