package io.file;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class TempDirDemo {
    public static void main(String[] args) throws IOException {
        String tmpdir = System.getProperty("java.io.tmpdir");
        System.out.println("tmpdir = " + tmpdir);

        File initialFile = new File("src/main/resources/sample.txt");
        byte[] sourceBytes = Files.readAllBytes(initialFile.toPath());

        String filename = "NEW_FILE.TXT";
        Path path = Path.of(tmpdir, filename);
        System.out.println("path = " + path);
        File file = new File(String.valueOf(path));
        try (OutputStream os = new FileOutputStream(file)) {
            os.write(sourceBytes);
        }
    }
}