package task7.multithread.task7.multithread.produser.consumer;

/**
 * @author Alexey Levchhenko
 */
public class Store {
    private Integer number;
    private boolean hasData = false;


    public synchronized int get() {
        while (!hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasData = false;
        notifyAll();
        return number;
    }

    public synchronized void put(int i) {

        while (hasData) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.number = i;
        hasData = true;
        notifyAll();
    }


}
