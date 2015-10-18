package task3.table;

import java.util.Iterator;

/**
 * @author Alexey Levchenko
 */
public class TableTest {

    public static void main(String[] args) throws PageHandlingException {

        SortPageTable table = new SortPageTable();
        table.setTitle(new String[]{"id", "1title", "2title", "3title"});
        table.setLinesInPage(10);

        table.add(1, "a", 50, 12.35d);
        table.add(2, "b", 49, 2.35d);
        table.add(3, "c", 48, 32.99d);
        table.add(4, "d", 47, 700d);
        table.add(5, "d", 46, 701d);
        table.add(6, "f", 45, 702d);
        table.add(7, "l", 44, 703d);
        table.add(8, "d", 43, 704d);
        table.add(9, "e", 42, 705d);
        table.add(10, "o", 41, 706d);

        table.add(11, "n", 40, 707d);
        table.add(12, "d", 39, 708d);
        table.add(13, "h", 38, 709d);
        table.add(14, "d", 37, 710d);
        table.add(15, "d", 36, 711d);
        table.add(16, "e", 35, 712d);
        table.add(17, "g", 34, 713d);
        table.add(18, "k", 33, 714d);
        table.add(19, "i", 32, 715d);
        table.add(20, "d", 31, 716d);

        table.add(21, "f", 30, 717d);
        table.add(22, "m", 29, 718d);


        table.sortByColumnIndex(1);

        for(int i = 0; i < table.pagesQty(); i++) {
            System.out.println("Page " + i + " start_________________");
            Iterator pageIterator = table.pageIterator(i);
            while (pageIterator.hasNext()) {
                System.out.println(pageIterator.next());
            }
            System.out.println("Page " + i + " end___________________");
            System.out.println();
        }
    }

}



