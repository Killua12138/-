package Concurrency;

public class LiftOff implements Runnable {
    protected int countDown = 10;
    private static int taskCount = 0;
    private final int id = taskCount++;

    public LiftOff() {

    }

    public LiftOff(int countDown) {
        this.countDown = countDown;
    }

    private String status() {
        return "#" + id + "(" + (countDown > 0 ? countDown : "LiftOff!") + ")";
    }

    @Override
    public void run() {
        synchronized (this) {
            while (countDown-- > 0) {
                System.out.println(status());
                Thread.yield();
            }
        }
    }

    public static void main(String[] argv) {
        Thread t = new Thread(new LiftOff());
        t.start();
        System.out.println("Wait--------------");
    }

}
