package threads.sync;

public class SyncDemo {

    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Thread threadA = new CounterThread(counter);
        Thread threadB = new CounterThread(counter);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();

        System.out.println(counter.count);
    }
} // end of class
