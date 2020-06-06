package concurrent.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;

public class CallableDemo {

    public static void main(String[] args) throws Exception {

        Callable<Integer> task = () -> {
            int result = ThreadLocalRandom.current().nextInt(1000);
            return result;
        };
        System.out.println(task.call());
    }
}