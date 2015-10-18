package task7.multithread.task7.multithread.produser.consumer;

/**
 * @author Alexey Levchhenko
 */
public class Producer implements Runnable {
    private Store store;

    public Producer(Store store) {
        this.store = store;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

    @Override
    public void run() {

        int i = 0;
        while (true) {
            i++;
            store.put(i);
        }

    }
}
