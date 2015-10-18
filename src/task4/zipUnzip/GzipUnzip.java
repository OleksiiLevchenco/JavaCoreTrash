package task4.zipUnzip;


import java.io.*;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;


/**
 * @author Alexey Levchenko
 */
public class GzipUnzip {

    public static byte[] objectToZipByteArray(Object o) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        GZIPOutputStream zipOutputStream = new GZIPOutputStream(byteArrayOutputStream);
        ObjectOutputStream oos = new ObjectOutputStream(zipOutputStream);
        oos.writeObject(o);
        oos.flush();
        oos.close();
        return byteArrayOutputStream.toByteArray();
    }

    public static Object zipByteArrayToObject(byte[] bytes) throws IOException, ClassNotFoundException {
        ByteArrayInputStream byteArray = new ByteArrayInputStream(bytes);
        GZIPInputStream zipInputStream = new GZIPInputStream(byteArray);
        ObjectInputStream ois = new ObjectInputStream(zipInputStream);
        return ois.readObject();
    }
}
