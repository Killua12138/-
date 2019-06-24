package Concurrency;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class FutureTaskDemo {
    public static void main(String[] argv) throws ExecutionException, InterruptedException {
        FutureTask<Integer> f = new FutureTask<Integer>(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                int res = 0;
                for (int i = 0; i < 100; i++){
                    TimeUnit.MILLISECONDS.sleep(10);
                    res+=i;
                }
                return res;
            }
        });
        new Thread(f).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("run....");
                try {
                    TimeUnit.MILLISECONDS.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        System.out.println(f.get());
    }
}
