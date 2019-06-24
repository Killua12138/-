package Concurrency;

import java.util.concurrent.*;

public class TestCallable implements Callable {
    int x = 0;
    @Override
    public Integer call() throws Exception {
        return x++;
    }
    public static void main(String[] argv) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        TestCallable testCallable = new TestCallable();
        Future<Integer> res = exec.submit(testCallable);
        FutureTask<Integer> tsk = new FutureTask<>(testCallable);
        exec.submit(tsk);
        System.out.println(res.get());
        System.out.println(tsk.get());
    }

}
