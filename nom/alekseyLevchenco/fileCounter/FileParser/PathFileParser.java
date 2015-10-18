package nom.alekseyLevchenco.fileCounter.FileParser;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * @author Alexey Levchhenko
 */
public interface PathFileParser{
    List<String> getPaths(String filePath) throws IOException;
}
