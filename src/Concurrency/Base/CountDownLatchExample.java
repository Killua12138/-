package Concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class CountDownLatchExample {
    public static void main(String[] argv) throws InterruptedException {
        Semaphore semaphore = new Semaphore(20);
        final int count = 10;
        CountDownLatch test = new CountDownLatch(count);
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0 ; i < 10;i++){
            exec.execute(() -> {
                System.out.print("run..");
                test.countDown();
            });
        }
        test.await();
        System.out.println("end");
        exec.shutdownNow();
    }
}
