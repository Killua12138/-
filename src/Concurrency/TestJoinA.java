package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestJoinA extends Thread{


    @Override
    public void run() {
        System.out.println("A");
    }

    private class TestJoinB extends Thread{
        TestJoinA a;
        private TestJoinB(TestJoinA a){
            this.a = a;
        }

        @Override
        public void run() {
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        }
    }
    public static void main(String[] argv){
        TestJoinA a = new TestJoinA();
        TestJoinB b = a.new TestJoinB(a);
        a.start();
        b.start();
    }

}
