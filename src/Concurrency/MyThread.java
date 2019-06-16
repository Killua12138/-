package Concurrency;

public class MyThread extends Thread{
    @Override
    public void run(){
        while(!interrupted());
    }
    public static void main(String[] argv){
        MyThread test = new MyThread();
        test.start();
        test.interrupt();
    }

}
