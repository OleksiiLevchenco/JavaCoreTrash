package nom.alekseyLevchenco.fileCounter;

import nom.alekseyLevchenco.fileCounter.Counter.FileCountingService;
import nom.alekseyLevchenco.fileCounter.FileParser.PathFileParser;
import nom.alekseyLevchenco.fileCounter.FileParser.PathFileParserImpl;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * @author Alexey Levchenko
 */
public class Main {
    FileCountingService service;

    public Main() {}

    public void run(String pathToSoursFile, String saveFileName) {

        List<String> folders = getFolders(pathToSoursFile);
        FullResultList results = countFiles2(folders);
        if(results.isFull()){
            show(results);
            saveToFile(saveFileName,results);
        } else {
            System.out.println("interrupted by user");
            show(results);
        }
    }

    private List<String> getFolders(String pathToSoursFile) {
        PathFileParser parser = new PathFileParserImpl();
        List<String> folders = null;
        try {
            folders = parser.getPaths(pathToSoursFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return folders;
    }

    private FullResultList countFiles2(List<String> folders) {
        service = new FileCountingService();
        return service.getResults(folders);
    }


    public void show(FullResultList results){
        int i = 1;
        System.out.printf("%-4s %-8s %s \n"," #" ,"qtt", "path");
        for (ResultLine result : results) {
            System.out.printf(" %-4s %-4s %-90s \n" ,i++ , result.getCountOfFiles() , result.getPath());
        }
    }

    public Thread getCurrentThread(){
        return Thread.currentThread();
    }

    private void saveToFile(String saveFileName, FullResultList results) {
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



}
