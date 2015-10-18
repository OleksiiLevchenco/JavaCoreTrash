package task7.multithread.task7.multithread.produser.consumer;

/**
 * @author Alexey Levchhenko
 */
public class Consumer implements Runnable {
    Store store;

    public Consumer(Store store) {
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
        while (true) {
            System.out.println(store.get());
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }



}
