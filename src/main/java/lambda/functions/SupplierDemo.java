package lambda.functions;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SupplierDemo {
    public static void main(String[] args) throws IOException {
        List<String> list;
        try (Stream<String> stream = Files.lines(Paths.get("src/main/resources/words.txt"))) {
            list = stream
                    .collect(Collectors.toList());
        }
        Supplier<Integer> lambda = () -> ThreadLocalRandom.current().nextInt(list.size());

        System.out.println("There are " + list.size() + " words.");
        System.out.println("Random word: " + list.get(lambda.get()));
    }
}