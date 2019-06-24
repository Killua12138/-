package Concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MyCallable implements Callable<Integer> {
    private int i;
    public MyCallable(int i){
        this.i = i;
    }
    @Override
    public Integer call() throws Exception {
        return i;
    }
    public static void main(String[] argv) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newCachedThreadPool();
        List<Future<Integer>> rs = new ArrayList<>();
        for (int i = 0 ; i < 5; i ++)
            rs.add(exec.submit(new MyCallable(i)));
        for(Future<Integer> i : rs)
            System.out.println(i.get());
    }
}
