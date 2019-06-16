package Concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxMatic {
    public static void main(String[] argv) throws InterruptedException {
        Car car = new Car();
        ExecutorService exec = Executors.newCachedThreadPool();
        exec.submit(new WaxOn(car));
        exec.submit(new WaxOff(car));
        exec.shutdownNow();
    }

}
class Car{
    private boolean waxOn = false;
    public synchronized void waxed(){
        waxOn = true;
        notifyAll();
    }
    public synchronized void buffed(){
        waxOn = false;
        notifyAll();
    }
    public synchronized void waitForWaxing() throws InterruptedException {
        while(waxOn == false)
            wait();
    }
    public synchronized void waitForBuffed() throws InterruptedException {
        while (waxOn == true)
            wait();
    }
    public void test(){
        notifyAll();
    }
}
class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car car){
        this.car = car;
    }
    @Override
    public void run() {
        try {
            while (!Thread.interrupted()){
                System.out.println("Wax On!");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffed();
            }
        } catch (InterruptedException e) {
                e.printStackTrace();
        }
        System.out.println("Ending Wax");
    }
}
class WaxOff implements Runnable{
    private Car car;
    public WaxOff(Car car){
        this.car = car;
    }
    @Override
    public void run(){
        try{
            while (!Thread.interrupted()){
                car.waitForWaxing();
                System.out.println("Wax off");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Ending Wax Off");
    }
}
