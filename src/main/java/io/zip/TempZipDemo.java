package io.zip;

import net.lingala.zip4j.ZipFile;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ThreadLocalRandom;
import static java.util.UUID.randomUUID;

public class TempZipDemo {

    private static final String randomFilesZip = "random.zip";

    public static void main(String[] args) throws IOException {
        String content = "test content";
        String zipPath = Paths.get("src", "main", "resources").toFile().getAbsolutePath();

        File target = new File(zipPath + "/" + randomFilesZip);
        if (target.exists()) {
            System.out.println("Zip file already exist. Deleting...");
            target.delete();
        }

        int zippedAmount = ThreadLocalRandom.current().nextInt(10, 100);
        String tempFolderPath = Files.createTempDirectory(null).toFile().getAbsolutePath();

        ZipFile zipFile = new ZipFile(zipPath + "/" + randomFilesZip);
        for (int i = 0; i < zippedAmount; i++) {
            String UUID = randomUUID().toString();
            Files.write(Paths.get(tempFolderPath, UUID + ".txt"), content.getBytes());
            File file = new File(tempFolderPath + "/" + UUID + ".txt");
            zipFile.addFile(file);
        }
    }
}