package stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class EmptyStreamMaxDemo {
    public static void main(String[] args) {
        List<Integer> emptyList = new ArrayList<>();
        Stream<Integer> stream = emptyList.stream();

        var max = stream.max(Comparator.comparingInt(Integer::intValue));
        System.out.println(max);
    }
}