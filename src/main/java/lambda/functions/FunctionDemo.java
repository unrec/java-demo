package lambda.functions;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<Long, Long> adder = new AddThree();
        Long result = adder.apply(4L);
        System.out.println("result = " + result);

        Function<Long, Long> lambda = (value) -> value + 3;
        Long resultLambda = lambda.apply(8L);
        System.out.println("resultLambda = " + resultLambda);
    }
}