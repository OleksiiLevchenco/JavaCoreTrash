package nom.alekseyLevchenco.fileCounter;

/**
 * @author Alexey Levchenko
 */
public class ResultLine {

    private String path;
    private int countOfFiles;
    private boolean correctFolder = true;

    public ResultLine(String path, int countOfFiles) {
        this.path = path;
        this.countOfFiles = countOfFiles;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getCountOfFiles() {
        return countOfFiles;
    }

    public void setCountOfFiles(int countOfFiles) {
        countOfFiles = countOfFiles;
    }

    public boolean isCorrectFolder() {
        return correctFolder;
    }

    public void setCorrectFolder(boolean correctFolder) {
        this.correctFolder = correctFolder;
    }

    @Override
    public String toString() {
        return "ResultLine{" +
                "path='" + path + '\'' +
                ", countOfFiles=" + countOfFiles +
                '}';
    }


}
