package Concurrency;

import java.util.concurrent.*;

public class CallableTest implements Callable {

    @Override
    public Integer call() throws Exception {
        return 123;
    }
    public static void main(String[] argv) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        Future<Integer> res = exec.submit(new CallableTest());
        Thread a = new Thread();
        a.join(10);
        System.out.println(res.get());
    }

}
