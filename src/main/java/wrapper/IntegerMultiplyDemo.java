package wrapper;

public class IntegerMultiplyDemo {

    public static void main(String[] args) {
        Integer i1 = Integer.MAX_VALUE;
        Integer i2 = 4;

        Integer result = i1*i2;
        System.out.println("result = " + result);

        Integer maxMultiply = Integer.MAX_VALUE * Integer.MAX_VALUE;
        System.out.println("maxMultiply = " + maxMultiply);
    }
}