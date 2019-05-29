package Concurrency;

import java.util.concurrent.*;

public class ProducerConsumer {
    private static BlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    private static class Producer extends Thread {
        @Override
        public void run() {
            try {
                queue.put("product");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("produce..");
        }
    }

    private static class Consumer extends Thread {

        @Override
        public void run() {
            try {
                String product = queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.print("consume..");
        }
    }
    public static void main(String[] argv){
        ExecutorService exec= Executors.newCachedThreadPool();
        exec.execute(new ProducerConsumer.Consumer());
        exec.execute(new ProducerConsumer.Consumer());
        exec.execute(new ProducerConsumer.Producer());
        exec.execute(new ProducerConsumer.Producer());
        exec.execute(new ProducerConsumer.Consumer());
        exec.shutdown();
        PriorityBlockingQueue test;
    }

}
