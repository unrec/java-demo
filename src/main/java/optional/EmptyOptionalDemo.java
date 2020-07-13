package optional;

import java.util.Optional;

public class EmptyOptionalDemo {
    public static void main(String[] args) {
        Optional<String> optional = Optional.of("SOME_VALUE");
        System.out.println(optional.orElse("null"));
        optional = Optional.empty();
        System.out.println(optional.orElse("null"));

        Optional<String> optional1 = Optional.empty();
        Optional<String> optional2 = Optional.empty();
        System.out.println("Optional.empty(): " + optional1.equals(optional2));
    }
}