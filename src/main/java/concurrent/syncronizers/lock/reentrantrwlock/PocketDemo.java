package concurrent.syncronizers.lock.reentrantrwlock;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class PocketDemo {
    public static void main(String[] args) {
        PocketManager pocketManager = new PocketManager();
        Random random = new Random();
        int poolAmount = 9;

        ExecutorService service = Executors.newFixedThreadPool(poolAmount);
        for (int i = 0; i < poolAmount; i++) {
            boolean addSum = random.nextBoolean();
            service.submit(new PocketThread(pocketManager, addSum));
        }
        service.shutdown();
    }
}