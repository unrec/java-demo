package concurrent.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

public class FutureDemo {

    public static void main(String[] args) throws InterruptedException {
        Calculator calculator = new Calculator();

        Future<Integer> future = calculator.calculate(10);

        while (!future.isDone()) {
            System.out.println("Calculating...");
            Thread.sleep(250);
        }

        Integer result = null;
        try {
            result = future.get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        } finally {
            calculator.shutdown();
        }
        System.out.println("result = " + result);
        System.out.println("End");

    }
}