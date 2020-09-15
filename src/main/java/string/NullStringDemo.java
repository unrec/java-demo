package string;

public class NullStringDemo {
    public static void main(String[] args) {
        String empty = "";
        boolean isNull = empty == null;
        boolean isEmpty = empty.isEmpty();
        boolean isBlank = empty.isBlank();

        System.out.println("isNull = " + isNull);
        System.out.println("isEmpty = " + isEmpty);
        System.out.println("isBlank = " + isBlank);
    }
}