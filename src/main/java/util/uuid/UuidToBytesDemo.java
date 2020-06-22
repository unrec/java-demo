package util.uuid;

import java.nio.ByteBuffer;
import java.util.UUID;

public class UuidToBytesDemo {

    public static void main(String[] args) {

        UUID uuid = UUID.randomUUID();
        System.out.println("Source uuid = " + uuid);

        byte[] bytesFromUUID = getBytesFromUUID(uuid);
        System.out.println("Converted uuid = " + getUUIDFromBytes(bytesFromUUID));

        String uuidAsString = uuid.toString();
        byte[] uuidAsBytes = uuidAsString.getBytes();
        System.out.println("Read form String uuid = " + UUID.fromString(new String(uuidAsBytes)));
    }

    public static byte[] getBytesFromUUID(UUID uuid) {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.putLong(uuid.getMostSignificantBits());
        bb.putLong(uuid.getLeastSignificantBits());
        return bb.array();
    }

    public static UUID getUUIDFromBytes(byte[] bytes) {
        ByteBuffer byteBuffer = ByteBuffer.wrap(bytes);
        Long high = byteBuffer.getLong();
        Long low = byteBuffer.getLong();
        return new UUID(high, low);
    }
}