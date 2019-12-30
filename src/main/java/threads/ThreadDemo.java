package threads;

public class ThreadDemo {

    public static class MyThread extends Thread {
        @Override
        public void run() {
//            System.out.println("Hello, World from Thread!");
            System.out.println(Thread.currentThread().getName());
        }

        public MyThread(String name) {
            super(name);
        }

    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
//            System.out.println("Hello, World from Runnable!");
        }
    }

    public static void main(String[] args) {

        System.out.println("Thread from main() - " + Thread.currentThread().getName());

        Thread myThread = new MyThread("My Thread Thread");
        myThread.setPriority(10);
        myThread.start();

        Thread runThread = new Thread(new MyRunnable(), "My Runnable Thread");
        runThread.setPriority(1);
        try {
            runThread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(runThread.getName());
        runThread.start();

        Runnable lambda = () -> System.out.println("Thread from lambda");

        Thread lambdaThread = new Thread(lambda);
        lambdaThread.start();

    }
}