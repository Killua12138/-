package Concurrency;

public class ThreadPrintTest {
    int i = 0;
    int count;

    public void ThreadPrint(int N) throws InterruptedException {
        Thread[] threads = new Thread[N];
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (i < 100) {
                    synchronized (this) {
                        if (count == N){
                            i++;
                            System.out.println(Thread.currentThread().getName() + ":" + i);
                        }
                    }
                }
            }
        };
        for (int i = 0; i < N; i++) {
            threads[i] = new Thread(runnable);
            threads[i].start();
            threads[i].setName("thread" + i);
        }
        int count1 = 0;
        while (i < 100) {
            count = N;
            threads[count1].join();
            count1 = (count1 + 1) % N;
        }
        System.out.println(i);
    }

    public static void main(String[] argv) throws InterruptedException {
        ThreadPrintTest test = new ThreadPrintTest();
        test.ThreadPrint(3);
    }

}
