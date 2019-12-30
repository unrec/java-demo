package threads;

public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread t1 = new Thread();
        t1.setPriority(7);

        ThreadGroup tg = new ThreadGroup("TG");
        tg.setMaxPriority(7);
        Thread t2 = new Thread(tg,"t2");

        System.out.print("priority t1 = "  + t1.getPriority());
        System.out.print(", priority t2 = "  + t2.getPriority());
        System.out.print(", priority tg = "  + tg.getMaxPriority());
    }
}