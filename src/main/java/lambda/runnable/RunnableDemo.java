package lambda.runnable;

public class RunnableDemo {
    public static void main(String[] args) {
        ConcurrentSpeaker speaker = new ConcurrentSpeaker();
        speaker.speak();
        Thread thread = new Thread(speaker);
        thread.start();
    }
}
