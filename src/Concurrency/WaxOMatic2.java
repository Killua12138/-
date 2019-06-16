package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class WaxOMatic2 {
    public static void main(String[] argv) throws InterruptedException {
        Car2 car2 = new Car2();
        WaxOn2 waxOn2 = new WaxOn2(car2);
        WaxOff2 waxOff2 = new WaxOff2(car2);
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.execute(waxOn2);
        exec.execute(waxOff2);
        TimeUnit.MILLISECONDS.sleep(5000);
        exec.shutdownNow();
        System.out.println("Ending");
    }

}
class Car2{
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();
    private boolean waxOn = false;

    public  void waxed(){
        lock.lock();
        try{
            waxOn = true;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void buffed(){
        lock.lock();
        try{
            waxOn = false;
            condition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void waitForWaxing() throws InterruptedException {
        lock.lock();
        try{
            while(waxOn == false)
                condition.await();
        }finally {
            lock.unlock();
        }
    }
    public void waitForBuffing() throws InterruptedException {
        lock.lock();
        try{
            while(waxOn == true)
                condition.await();
        }finally {
            lock.unlock();
        }
    }
}
class WaxOn2 implements Runnable{
    private Car2 car2;
    public WaxOn2(Car2 car2){
        this.car2 = car2;
    }
    public void run(){
        try{
            while (!Thread.interrupted()){
                System.out.println("Wax On");
                TimeUnit.MILLISECONDS.sleep(200);
                car2.waxed();
                car2.waitForBuffing();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax On");
    }
}
class WaxOff2 implements Runnable{
    private Car2 car2;
    public WaxOff2(Car2 car2){
        this.car2 = car2;
    }
    public void run(){
        try{
            while (!Thread.interrupted()){
                car2.waitForWaxing();
                System.out.println("Wax off");
                TimeUnit.MILLISECONDS.sleep(200);
                car2.buffed();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax Off");
    }
}

