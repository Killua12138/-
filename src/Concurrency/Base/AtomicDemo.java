package Concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicDemo {
    private AtomicInteger atom = new AtomicInteger();
    static int a = 0;

    public void add(){
        //atom.getAndIncrement();
        a++;
    }

    public int get(){
        return a;
    }

    public static void main(String[] argv) throws InterruptedException{
        ExecutorService exec = Executors.newCachedThreadPool();
        AtomicDemo atom = new AtomicDemo();
        CountDownLatch count = new CountDownLatch(100);
        for (int i = 0; i < 100; i++){
            exec.execute(new Runnable() {
                @Override
                public void run() {
                    atom.add();
                    count.countDown();
                }
            });
        }
        exec.shutdown();
        count.await();
        System.out.println(atom.get());
    }

}
