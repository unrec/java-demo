package batch;

import com.google.common.collect.Iterables;
import com.google.common.collect.Iterators;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BatchProcessDemo {
    public static void main(String[] args) {
        List<Integer> list = generateBatch(100);

        // print batches
        Iterables.partition(list, 10).forEach(System.out::println);

        // print elements of batches
        Iterables.partition(list, 10).forEach(integers -> integers.forEach(System.out::println));
    }

    private static List<Integer> generateBatch(int amount) {
        return IntStream.rangeClosed(0, amount).boxed().collect(Collectors.toList());
    }
}