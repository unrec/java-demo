package lambda.runnable;

public class Speaker implements Runnable {
    public void speak() {
        System.out.println(Thread.currentThread().getName() +
                " - Hello, world! [speak]");
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() +
                " - Hello, world! [thread]");
    }
}