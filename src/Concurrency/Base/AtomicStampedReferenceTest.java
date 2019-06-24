package Concurrency;


import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class AtomicStampedReferenceTest {
    private static AtomicStampedReference<Integer> test = new AtomicStampedReference<>(100,0);
    static Thread ref1 = new Thread(new Runnable() {
        @Override
        public void run() {
            test.compareAndSet(100,101,test.getStamp(),test.getStamp()+1);
            System.out.println("thread ref1:" + test.getReference()+"stamp = "+test.getStamp());
            test.compareAndSet(101,100,test.getStamp(),test.getStamp()+1);
            System.out.println("thread ref1:" + test.getReference()+"stamp = "+test.getStamp());
        }
    });
    static Thread ref2 = new Thread(new Runnable() {
        @Override
        public void run() {
            int stamp = test.getStamp();
            System.out.println("before sleep stamp = "+stamp);
            System.out.println("after sleep stamp = " + stamp);
            boolean c3 = test.compareAndSet(100,101,stamp,stamp+1);
            System.out.println(c3);
        }
    });
    public static void main(String[] argv){
        ref1.start();
        ref2.start();
    }

}
