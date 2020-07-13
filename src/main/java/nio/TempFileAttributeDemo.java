package nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.security.NoSuchAlgorithmException;
import java.time.Instant;

public class TempFileAttributeDemo {
    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        Path tempFile = Files.createTempFile(null, null);
        System.out.println("tempFile = " + tempFile);

        Path path = Files.setAttribute(tempFile, "creationTime", FileTime.from(Instant.now()
                .minusSeconds(10000 * 24 * 60 * 60)));
        System.out.println(Files.readAttributes(path, "creationTime"));
    }
}