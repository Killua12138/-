package Concurrency;

import java.sql.Time;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestWait {
    public static void main(String[] argv) throws InterruptedException {
        Num num = new Num();
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++){
            exec.submit(new Task(i,num));
        }
        exec.shutdown();
    }

}
class Num{
    int num = 0;
}
class Task implements Runnable{
    private int id;
    private Num num;
    public Task (int id,Num num){
        this.id = id;
        this.num = num;
    }
    @Override
    public void run() {
        try{
            synchronized(num){
                while (id != num.num){
                    System.out.println("id: " + id);
                    num.wait();
                }
                System.out.println(id);
                num.num++;
                num.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
