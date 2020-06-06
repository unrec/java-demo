package concurrent.future;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ThreadPoolDemo {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Integer> list = generateBatch(100);
        Map<Object, Integer> counter = new ConcurrentHashMap<>();

        list.forEach(element ->
                executorService.execute(() -> {
                    String thread = Thread.currentThread().getName();
                    System.out.printf("Thread: %s, element: %s\n",
                            thread, element);
                    counter.put(thread, counter.getOrDefault(thread, 0) + 1);

                }));
        executorService.shutdown();
        Thread.sleep(100);
        System.out.println("Threads used: "+ counter.keySet().size());
        Thread.sleep(500);
        counter.forEach((k, v) -> System.out.println(String.format("Key: %s, value: %s", k, v)));
    }

    private static List<Integer> generateBatch(int amount) {
        return IntStream.rangeClosed(1, amount).boxed().collect(Collectors.toList());
    }
}
