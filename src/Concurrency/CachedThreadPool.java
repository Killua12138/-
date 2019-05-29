package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CachedThreadPool {
    LiftOff liftOff;
    public static void main(String[] argv){
        ExecutorService exec = Executors.newCachedThreadPool();
        ExecutorService exec1 = Executors.newFixedThreadPool(5);
        for (int i = 0 ; i < 5; i ++){
            exec.execute(new LiftOff());
            //exec1.execute(new LiftOff());
        }
        exec1.shutdown();
        exec.shutdown();//防止新任务继续提交
    }
}
