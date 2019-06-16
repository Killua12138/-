package Concurrency;

import jianzhi.Print;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class BlockQueueDemo{
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);
    static class Produce implements Runnable{
        public void run(){
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("put()");
        }
    }
    static class Consumer implements Runnable{
        public void run(){
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("take()");
        }
    }
    public static void main(String[] argv){
        ExecutorService exec = Executors.newCachedThreadPool();
        for (int i = 0;i < 2;i++) {
            exec.execute(new Produce());
        }
        for (int i = 0;i < 5;i++){
            exec.execute(new Consumer());
        }
        for (int i = 0;i < 3;i++){
            exec.execute(new Produce());
        }
    }

}
