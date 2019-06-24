package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EvenCheck implements Runnable {
    private IntGenerator generator;
    private final int id;

    public EvenCheck(IntGenerator g, int ident) {
        this.generator = g;
        id = ident;
    }

    @Override
    public void run() {
        while (!generator.isCanceled()) {
            int val = generator.next();
            if (val % 2 != 0) {
                System.out.println(val + "not even");
                generator.cancel();
            }
        }
    }

    public static void test(IntGenerator g, int count) {
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < count; i++) {
            exec.execute(new EvenCheck(g, i));//多个EvenCheck任务对同一个IntGenerator资源访问
        }
        exec.shutdown();
    }
    public static void test(IntGenerator g){
        test(g,10);
    }
}
