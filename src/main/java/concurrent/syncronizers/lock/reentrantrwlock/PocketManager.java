package concurrent.syncronizers.lock.reentrantrwlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PocketManager {
    private final ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private final Lock readLock = lock.readLock();
    private final Lock writeLock = lock.writeLock();

    // write operation
    public void getSum(Pocket pocket, int sum) {
        writeLock.lock();
        try {

            if (pocket.getMoney() <= 0 || sum > pocket.getMoney()) {
                System.out.println(Thread.currentThread().getName() + ". " +
                        "Trying to take " + sum + " when " + pocket.getMoney() + " in the pocket");
//                        "Sum in the the pocket is not enough.");
                return;
            }

            TimeUnit.MILLISECONDS.sleep(250); // wait
            System.out.println(Thread.currentThread().getName() + ". " +
                    "Amount of " + sum +
                    " is taken by " + Submitter.getRandom());
            pocket.setMoney(pocket.getMoney() - sum);

            // do not take too often
            TimeUnit.MILLISECONDS.sleep(1000); // wait

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    // write operation
    public void addSum(Pocket pocket, int sum) {
        writeLock.lock();
        try {

            TimeUnit.MILLISECONDS.sleep(250); // wait
            System.out.println(Thread.currentThread().getName() + ". " +
                    "Amount of " + sum +
                    " is added by " + Submitter.getRandom());
            pocket.setMoney(pocket.getMoney() + sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }
    }

    // read operation
    public void seeSum(Pocket pocket) {
        try {
            readLock.lock();
            TimeUnit.MILLISECONDS.sleep(250); // wait
            System.out.println(Thread.currentThread().getName() + ". " +
                    "Current amount is " + pocket.getMoney() +
                    " (peeped by " + Submitter.getRandom() + ")");

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }
    }

    // constructor
    PocketManager() {
    }
}