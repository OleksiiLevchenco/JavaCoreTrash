import java.util.Random;

public class Main {

    public static long result=0;

    public static synchronized void sumOfThreads(long sum){
        result+=sum;
    }

    public static void main(String[] args) throws InterruptedException {

        long timeCounter=0;
        int[]arr = randArr(200);
        long singlSum=0;

        timeCounter=System.nanoTime();
        for(int i=0;i<arr.length;i++){
        singlSum+=arr[i];
        Thread.sleep(10);
        //        System.out.println(arr[i]);
        }
        timeCounter-= System.nanoTime();

        System.out.println("однапроходная сумма=" + singlSum + "  за время,ms=" + timeCounter / 1000);
        timeCounter=0;


        timeCounter= System.nanoTime();
        ArraySummingRunnable R1 = new ArraySummingRunnable();
        ArraySummingRunnable R2 = new ArraySummingRunnable();

        R1.length=arr.length/2;
        R1.arr=new int[R1.length];
        System.arraycopy(arr,0,R1.arr,0,R1.length);

        R2.length=arr.length-1;
        R2.arr=new int[arr.length-R1.arr.length];
        System.arraycopy(arr, arr.length/2, R2.arr, 0, R2.arr.length);

//        System.out.println(arr.length/2);
//        for(int i=0;i<R2.arr.length;i++){
//            System.out.println(R2.arr[i]);
//        }

        Thread T1 =new Thread(R1);
        Thread T2 =new Thread(R2);
        T1.start();
        T2.start();
        T1.join();
        T2.join();
        timeCounter-=System.nanoTime();

        System.out.println("сумма вычесленная двумя потоками=" + Main.result + "  за время,ms=" + timeCounter / 1000);
    }

    public static int[] randArr(int n){
        Random rand=new Random();
        int[]arr=new int[n];
        for(int i=0;i<n;i++){
            arr[i]=rand.nextInt(50);
        }
        return arr;
    }
}
