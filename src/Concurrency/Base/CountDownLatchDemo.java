package Concurrency;

import edu.princeton.cs.algs4.Count;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CountDownLatchDemo {
    static final int SIZE = 100;
    public static void main(String[] argv){
        ExecutorService exec = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(SIZE);
        for (int i = 0; i < 10; i++)
            exec.execute(new WaitingTask(latch));
        for (int i = 0; i < SIZE; i++)
            exec.execute(new TaskPortion(latch));
        System.out.println("END");
        exec.shutdown();
    }

}
class TaskPortion implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private static Random rand = new Random(47);
    private final CountDownLatch latch;
    public TaskPortion(CountDownLatch latch){
        this.latch = latch;
    }
    public void run(){
        try{
            doWork();
            latch.countDown();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void doWork() throws InterruptedException {
        TimeUnit.MILLISECONDS.sleep(rand.nextInt(2000));
        System.out.println("id: " + id + " completed");
    }
}
class WaitingTask implements Runnable{
    private static int counter = 0;
    private final int id = counter++;
    private final CountDownLatch latch;
    public WaitingTask(CountDownLatch latch){
        this.latch = latch;
    }
    public void run(){
        try {
            latch.await();
            System.out.println("pass for " + id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
