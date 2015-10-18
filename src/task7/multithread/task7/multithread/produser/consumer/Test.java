package task7.multithread.task7.multithread.produser.consumer;

/**
 * @author Alexey Levchhenko
 */
public class Test {
    public static void main(String[] args) {
        Store store = new Store();
        new Thread(new Producer(store)).start();
        new Thread(new Consumer(store)).start();


    }

}
