import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.*;

/**
 * @author Alexey Levchenko
 */
public class StringToZipTXT {

    private static String s1 = "По мотивам многочисленных дискуссий решил высказать\r\n свое мнение по поводу обратной \n" +
            "стороны медали при использовании Apache Maven. Единственное, для чего я это делаю – показать,\n";

    private static String s2 = "1243124   1243124124   124124645798945";

    public static void putToZip() throws IOException {
        File file = new File("testZip.zip");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        ZipEntry zipEntry = new ZipEntry("String.txt");
        zipOutputStream.putNextEntry(zipEntry);
        zipOutputStream.write(s1.getBytes());
        zipOutputStream.closeEntry();

        ZipEntry zipEntry1 = new ZipEntry("digits.txt");
        zipOutputStream.putNextEntry(zipEntry1);
        zipOutputStream.write(s2.getBytes());
        zipOutputStream.closeEntry();

        zipOutputStream.flush();
        zipOutputStream.close();

    }

    public static void putToGzip() throws IOException {
        String name = "GZip.zip";
        GZIPOutputStream zipOutput = new GZIPOutputStream(new FileOutputStream(name));
        zipOutput.write(15);
        zipOutput.flush();
        zipOutput.close();
        System.out.println(new GZIPInputStream(new FileInputStream(name)).read());
    }

    public static void readZip() throws IOException{
        byte[] buffer = new byte [1024];
        List<String> strings = new ArrayList<String>();
        File file = new File("testZip.zip");
        ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
        ZipEntry entry = zis.getNextEntry();
        while (entry != null){
            int length;
            int index;
            byte[] temp;
            strings.add(new String());
            while ((length = zis.read(buffer) ) > 0){

            }
        }
        



    }

    public static void main(String[] args) throws IOException {

    }
}
