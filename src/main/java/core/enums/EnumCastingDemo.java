package core.enums;

public class EnumCastingDemo {
    public static void main(String[] args) {
        Object status = "ACTIVE";

        System.out.println(Status.valueOf(status.toString()));
        System.out.println(Status.valueOf(status.toString()).getClass());
    }
}