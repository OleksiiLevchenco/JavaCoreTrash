package task7.multithread;

import java.util.concurrent.CompletionStage;

/**
 * @author Alexey Levchhenko
 */
public class Waiter implements Runnable {

    private String waiterName;
    private Food food;
    private Cook cook;
    private Client client;


    public Waiter(String waiterName, Client client) {
        this.waiterName = waiterName;
        this.client = client;
    }


    public String getWaiterName() {
        return waiterName;
    }

    public void setWaiterName(String waiterName) {
        this.waiterName = waiterName;
    }

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Cook getCook() {
        return cook;
    }

    public void setCook(Cook cook) {
        this.cook = cook;
    }

    @Override
    public void run() {
        while ( !Thread.currentThread().isInterrupted() ){

            while (food == null) {
                try {
                    Thread.currentThread().wait();
                } catch (InterruptedException e) {
                    System.out.println();
                }
            }

            if (food != null) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                client.addFood(food);
                food = null;
            }

            cook.notify();

        }


    }
}
