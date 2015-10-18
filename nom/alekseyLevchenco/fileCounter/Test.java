package nom.alekseyLevchenco.fileCounter;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author Alexey Levchhenko
 */
public class Test {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        Main main = new Main();
        Interrupter interrupter = new Interrupter();
        interrupter.addThreadToInterruption(main.getCurrentThread());
        Thread inter;
        inter = new Thread(interrupter);
        inter.start();
        main.run("G:\\Головач Курсы Java\\Лекция 1 Procedural\\test\\paths.txt", "G:\\Головач Курсы Java\\Лекция 1 Procedural\\test\\results.txt");


    }
}
