package optional;

import java.util.List;
import java.util.Optional;

public class OptionalOrElseDemo {

    public static void main(String[] args) {
        List<String> words = List.of("arm", "book", "cup");
        String word = Optional.of(words.get(1))
                .orElseThrow(ArrayIndexOutOfBoundsException::new);

        System.out.println("word = " + word);
    }
}