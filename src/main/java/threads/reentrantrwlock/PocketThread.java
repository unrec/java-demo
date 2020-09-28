package threads.reentrantrwlock;

//import org.apache.commons.math3.random.RandomDataGenerator;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class PocketThread extends Thread {
    private PocketManager pocketManager;
    private boolean changeStatus;
    private static Pocket pocket = new Pocket(5000);
    private static Random random = new Random();
    private static final int LEFT_LIMIT = 10;
    private static final int RIGHT_LIMIT = 10000;

    @Override
    public void run() {
//        int amount = new RandomDataGenerator().nextInt(LEFT_LIMIT, RIGHT_LIMIT);
        int amount = ThreadLocalRandom.current().nextInt(LEFT_LIMIT, RIGHT_LIMIT);
        if (changeStatus) {
            if (random.nextBoolean()) {
                pocketManager.addSum(pocket, amount);
            } else pocketManager.getSum(pocket, amount);
        } else {
            pocketManager.seeSum(pocket);

        }
    }

    // constructor
    PocketThread(PocketManager pocketManager, boolean addStatus) {
        this.pocketManager = pocketManager;
        this.changeStatus = addStatus;
    }

}
