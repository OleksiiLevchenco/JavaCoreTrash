package nom.alekseyLevchenco.fileCounter;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;

public class CharSetTest {
    public static void main(String[] args) throws IOException {
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.setProperty("file.encoding", "Latin-1");
        System.out.println("file.encoding=" + System.getProperty("file.encoding"));
        System.out.println("Default Charset=" + Charset.defaultCharset());
        System.out.println("Default Charsettt in Use=" + getDefaultCharSet());
        System.in.read();
    }

    private static String getDefaultCharSet() {
        OutputStreamWriter writer = new OutputStreamWriter(new ByteArrayOutputStream());
        String enc = writer.getEncoding();
        return enc;
    }
}
