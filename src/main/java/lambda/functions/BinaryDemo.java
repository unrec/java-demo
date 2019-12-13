package lambda.functions;

import java.util.function.BinaryOperator;

public class BinaryDemo {
    public static void main(String[] args) {
        BinaryOperator<Integer> addThenMultiply = (a, b) -> ((a + b) * a * b);
        System.out.println(addThenMultiply.apply(10,5));
    }
} // end of class