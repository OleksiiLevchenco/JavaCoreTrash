package nom.alekseyLevchenco.fileCounter.FileParser;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Alexey Levchenko
 */
public class PathFileParserImpl implements PathFileParser {
    @Override
    public List<String> getPaths(String filePath) throws IOException {
        List<String> result = new ArrayList<>();
        String line = null;
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        while ((line = reader.readLine()) != null ){
            result.add(line);
        }
        reader.close();
        return result;
    }
}
