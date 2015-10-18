package task7.multithread;

import oracle.jrockit.jfr.jdkevents.ThrowableTracer;
import task5.xml.Transformer;

/**
 * @author Alexey Levchenko
 */
public class Cook implements Runnable {
    
    private String cookName;
    private Waiter waiter;
    private int foodNameGen = 0;
    private Restaurant restaurant;


    public Cook(String name, Waiter waiter, Restaurant restaurant) {
        this.cookName = name;
        this.waiter = waiter;
        this.waiter.setCook(this);
        this.restaurant = restaurant;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String name) {
        this.cookName = name;
    }

    @Override
    public void run() {
//        while (!Thread.currentThread().isInterrupted()) {
//            foodNameGen++;
//            System.out.println("Повар " + cookName + " начал готовить блюдо" + foodNameGen);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//                System.out.println("Do not disturb the Cook!!!");
//            }
//            System.out.println("Готово, " + foodNameGen + ", повар " + cookName);
//            waiter.setFood(new Food("" + foodNameGen, 0.5f));
//            waiter.notify();
//            if (foodNameGen >= 10) {
//                restaurant.close();
//            }
//            try {
//                Thread.currentThread().wait();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


    }
}
