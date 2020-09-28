package lambda.functions;

import java.util.function.UnaryOperator;

public class UnaryDemo {
    public static void main(String[] args) {
        UnaryOperator<String> left = (string) -> string.substring(0, string.length() / 2);
        UnaryOperator<String> right = (string) -> string.substring(string.length() / 2);

        String fullSting = "00001111";
        String leftPart = left.apply(fullSting);
        String rightPart = right.apply(fullSting);
        System.out.println("Left - " + leftPart);
        System.out.println("Right - " + rightPart);
    }
}