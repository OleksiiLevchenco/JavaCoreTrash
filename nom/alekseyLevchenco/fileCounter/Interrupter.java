package nom.alekseyLevchenco.fileCounter;

import java.util.ArrayList;
import java.util.List;


/**
 * @author Alexey Levchhenko
 */
public class Interrupter implements Runnable {
    List<Thread> toInterrupt = new ArrayList<>();

    public Interrupter() {
    }

    public Interrupter(List<Thread> toInterrupt) {
        this.toInterrupt = toInterrupt;
    }

    public void addThreadToInterruption(Thread t) {
        toInterrupt.add(t);
    }

    @Override
    public void run() {

        try {
            Thread.sleep(11300);
        } catch (InterruptedException e) {
            System.out.println("Interrupter interrupt");
            return;
        }
        for (Thread thread : toInterrupt) {
            thread.interrupt();
        }
        System.out.println("Interrupter finish");

//        System.out.println("for interrupting of counting enter 'q'");
//        Scanner scanner = new Scanner(System.in);
//        while (!scanner.hasNext("^q$")) {
//            System.out.println(" incorrect input ");
//            scanner.next();
//        }

    }
}
