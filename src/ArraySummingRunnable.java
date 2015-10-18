import java.util.Random;


public class ArraySummingRunnable implements Runnable {
    public int[] arr;
    public int length;
    public volatile long resultSum;

    @Override
    public void run() {
        long sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    Main.sumOfThreads(sum);
    }

}


