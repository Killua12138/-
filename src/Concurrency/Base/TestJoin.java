package Concurrency;

import java.util.concurrent.TimeUnit;

public class TestJoin {
    private static int num = 0;

    public synchronized void printf(){
        while (true){
            System.out.println(num);
        }
    }
    public static void main(String[] argv) throws InterruptedException {
        TestJoin t = new TestJoin();
        A a = new A(t);
        B b = new B(t,a);
        a.start();
        b.start();
    }

}
class A extends Thread{
    private TestJoin t;
    public A(TestJoin t){
        this.t = t;
    }
    public void run(){
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("A");
        t.printf();
    }
}
class B extends Thread{
    private TestJoin t;
    private A a;
    public B(TestJoin t,A a){
        this.t = t;
        this.a = a;
    }
    public void run(){
        synchronized (t){
            System.out.println("B");
            try {
                a.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

