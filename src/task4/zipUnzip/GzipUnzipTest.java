package task4.zipUnzip;


import java.io.IOException;

/**
 * @author Alexey Levchenko
 */
public class GzipUnzipTest {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        TestClass testObject = new TestClass("qwerty", 15, 3.1415d);


        byte[] arr = GzipUnzip.objectToZipByteArray(testObject);

        TestClass unzip =(TestClass)GzipUnzip.zipByteArrayToObject(arr);

        System.out.println(unzip);

    }
}
