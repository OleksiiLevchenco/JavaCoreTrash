package task3.table;

import java.util.*;

/**
 * @author Alexey Levchenko
 */
public class SortPageTable implements Iterable {

    private List<Map<String, Comparable>> baseTable = new ArrayList<>();
    private String[] title;
    private int linesInPage = 10;


    public SortPageTable() {
    }

    public SortPageTable(String[] title) {
        this.title = title;
    }


    public void add(Map<String, Comparable> line) {
        baseTable.add(line);
    }

    public void add(Comparable... items) {
        Map<String, Comparable> line = new LinkedHashMap<String, Comparable>();
        int i = 0;
        for (Comparable item : items) {
            line.put(title[i++], item);
        }
        this.baseTable.add(line);
    }


    public void sortByColumnTitle(String columnTitle) {
        Collections.sort(this.baseTable, new ColumnComparator(columnTitle));
    }

    public void sortByColumnIndex(int index) {
        Collections.sort(this.baseTable, new ColumnComparator(title[index]));
    }


    /*
    * pagination
    */
    public int pagesQty() {
        return (int) Math.ceil((double) baseTable.size() / linesInPage);
    }

    private List<Map<String, Comparable>> page(int pageIndex) throws PageHandlingException {
        if (pageIndex < (pagesQty()) || pageIndex < 0) {
            int fromIndex = pageIndex * linesInPage;
            int toIndex = fromIndex + linesInPage - 1;
            if (toIndex >= baseTable.size()) {
                toIndex = baseTable.size() - 1;
            }
            return baseTable.subList(fromIndex, toIndex + 1);
        } else throw new PageHandlingException("Invalid index page" + pageIndex);
    }

    public Iterator pageIterator(int index) throws PageHandlingException {
        return page(index).iterator();
    }


    @Override
    public Iterator iterator() {
        return baseTable.iterator();
    }

    public void setBaseTable(List<Map<String, Comparable>> baseTable) {
        this.baseTable = baseTable;
    }

    public void setTitle(String[] title) {
        this.title = title;
    }

    public String[] getTitle() {
        return title;
    }

    public String getTitle(int index) {
        return title[index];
    }

    public int getLinesInPage() {
        return linesInPage;
    }

    public void setLinesInPage(int linesInPage) {
        this.linesInPage = linesInPage;
    }

}
