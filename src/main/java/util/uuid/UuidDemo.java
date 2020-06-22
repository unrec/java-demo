package util.uuid;

import java.util.UUID;

public class UuidDemo {

    public static final String UUID_PATTERN = "^[0-9a-f]{8}-[0-9a-f]{4}-[1-5][0-9a-f]{3}-[89ab][0-9a-f]{3}-[0-9a-f]{12}$";

    public static void main(String[] args) {
        String uuid = "0c5b2444-70a0-4932-980c-b4dc0d3f02b5";

        System.out.println("is UUID? - " + uuid.matches(UUID_PATTERN));
        System.out.println("is UUID? - " + isUUID(uuid));

        try {
            System.out.println("valid =" + UUID.fromString("1-1-1-1-1").toString());
        } catch (IllegalArgumentException exception) {
            System.out.println("not valid");
        }
    }

    static boolean isUUID(String string) {
        try {
            UUID.fromString(string);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }
}