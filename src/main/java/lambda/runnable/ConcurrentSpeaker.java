package lambda.runnable;

public class ConcurrentSpeaker extends Speaker {
    public void speak() {
        Thread t = new Thread(super::speak);
        t.start();
    }
}