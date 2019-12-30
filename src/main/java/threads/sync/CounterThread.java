package threads.sync;

public class CounterThread extends Thread {

    private Counter counter;

    CounterThread(Counter counter) {
        this.counter = counter;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            counter.add(i);
        }
    }
}