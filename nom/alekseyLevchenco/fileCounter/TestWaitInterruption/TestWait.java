package nom.alekseyLevchenco.fileCounter.TestWaitInterruption;

import java.io.IOException;

/**
 * @author Alexey Levchhenko
 */
public class TestWait {
    public static void main(String[] args) throws IOException {
        Thread waiter = new Thread(new Waiter());
        waiter.start();
        System.in.read();
    }
}
