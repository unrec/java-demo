package io.file;

import java.io.*;
import java.nio.file.Paths;

public class FileReadDemo {
    public static void main(String[] args) {
        String path = "src/main/resources/sample.txt";
        try (InputStream is = new FileInputStream(new File(Paths.get(path).toUri()))) {
            System.out.println(new String(is.readAllBytes()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}