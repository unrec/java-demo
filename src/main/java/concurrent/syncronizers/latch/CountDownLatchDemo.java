package concurrent.syncronizers.latch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(10);

        long time = System.currentTimeMillis();

        for (int i = 0; i < 10; i++) {
            CustomThread thread = new CustomThread(latch);
            thread.start();
            thread.join();
        }

        latch.await();
        System.out.printf("Runtime: %d milliseconds", System.currentTimeMillis() - time);
    }
}

class CustomThread extends Thread {
    CountDownLatch latch;

    public CustomThread(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        System.out.printf("%s started\n", Thread.currentThread().getName());
        try {
            Thread.sleep(1000, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        latch.countDown();
        System.out.printf("%s finished\n", Thread.currentThread().getName());
    }
}