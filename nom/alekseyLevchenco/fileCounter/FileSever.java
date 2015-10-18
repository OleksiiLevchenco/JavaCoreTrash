package nom.alekseyLevchenco.fileCounter;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author Alexey Levchenko
 */
public class FileSever implements Runnable {
    private String saveFileName;
    private List<ResultLine> results;
    private CountDownLatch latch;

    public FileSever(String saveFileName, List<ResultLine> results, CountDownLatch latch) {
        this.saveFileName = saveFileName;
        this.results = results;
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            latch.await();
        } catch (InterruptedException e) {
            System.out.println("latch Exception");
        }
        show();
        StringBuilder stringBuilder = new StringBuilder();
        String lineSeparator = System.getProperty("line.separator");
        for (ResultLine result : results) {
            stringBuilder.append(result.getPath());
            stringBuilder.append(";");
            stringBuilder.append(result.getCountOfFiles());
            stringBuilder.append(lineSeparator);
        }
        try(PrintWriter out = new PrintWriter(saveFileName)) {
            out.print(stringBuilder.toString());
            out.close();
            System.out.println("results were successfully written");
        } catch (FileNotFoundException e) {
            System.out.println("I/O Exception");
        }
    }

    private void show() {
        int i = 1;
        System.out.printf("%-4s %-8s %s \n"," #" ,"qtt", "path");
        for (ResultLine result : results) {
            System.out.printf(" %-4s %-4s %-90s \n" ,i++ , result.getCountOfFiles() , result.getPath());
        }
    }
}
