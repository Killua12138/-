package Concurrency;

import java.io.IOException;

public class ResponsiveUI extends Thread {
    private static volatile double d = 1;

    public ResponsiveUI() {
        start();
    }

    public void run() {
        while (true) {
            d = (Math.PI + Math.E) / d;
        }
    }
    public static void main(String[] argv) throws IOException {
        new ResponsiveUI();
        int a =System.in.read();
        System.out.println(d);
        System.out.println(a);
    }

}
