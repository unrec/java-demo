package optional;

import java.util.Optional;

public class ParseIntDemo {
    public static void main(String[] args) {

        Integer integer1 = parseInt("123");
        System.out.println("integer1 = " + integer1);
        Integer integer2 = tryParse("abc");
        System.out.println("integer2 = " + integer2);
    }

    private static Integer parseInt(String source) {
        return Optional.of(Integer.parseInt(source)).orElse(null);
    }

    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return null;
        }
    }
}