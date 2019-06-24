package Concurrency;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class Syntest1 {
    public static void main(String[] argv){
        Object o1 = new Object();
        final DualSynch ds = new DualSynch(o1);
        final DualSynch ds1 = new DualSynch(new Object());
        new Thread(){
            public void run(){
                ds.f();
                ds.g();
                Thread.yield();
            }
        }.start();
        new Thread(){
            public void run(){
                DualSynch.d();
                Thread.yield();
            }
        }.start();
        new Thread(){
            public void run(){
                ds1.f();
                ds1.g();
                Thread.yield();
            }
        }.start();
        AtomicIntegerArray arr = new AtomicIntegerArray(1);
    }

}
class DualSynch{
    static int count = 0;
    public final int id = count++;
    private Object syncObejct;
    static synchronized void d(){
        for(int i = 0; i < 5; i++) {
            System.out.println("d()");
            Thread.yield();
        }
    }
    public DualSynch(Object o1){
        syncObejct = o1;
    }
    public synchronized void f(){
        for (int i = 0; i < 5;i++){
            System.out.println("f()"+" "+id);
            Thread.yield();
        }
    }
    public void g(){
        synchronized (Object.class){
            for (int i = 0; i < 5; i++){
                System.out.println("g()"+ " "+ id);
                Thread.yield();
            }
        }
    }
}
