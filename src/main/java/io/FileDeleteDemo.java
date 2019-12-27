package io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;

public class FileDeleteDemo {

    private static final String FILE_PATH = "src/main/java/io/temp-txt-file.txt";

    private static void createTxtFile(String path) throws IOException {
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(path), StandardCharsets.UTF_8))) {
            writer.write("Lorem ipsum dolor sit amet, consectetur adipiscing elit.\n" +
                    "Praesent porttitor libero sit amet lacus bibendum viverra.\n" +
                    "Proin at nisl at erat lacinia condimentum nec vel ligula. Nulla facilisi.\n" +
                    "Integer quis ex ac sem iaculis lobortis vitae non quam.\n" +
                    "Vestibulum at laoreet nibh, eu pellentesque ligula.");
            System.out.println("File was created.");
        }
    }

    private static void deleteFile(String path) {
        // io implementation
        File file = new File(FILE_PATH);
        if (file.delete()) {
            System.out.println("File was deleted.");
        } else System.out.println("File was not found.");

        // nio implementation
        // https://docs.oracle.com/javase/tutorial/essential/io/delete.html
//        Path nioPath = Paths.get(FILE_PATH);
//        try {
//            Files.delete(nioPath);
//            System.out.println("File was deleted.");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    public static void main(String[] args) throws IOException {
        createTxtFile(FILE_PATH);
        deleteFile(FILE_PATH);
    }
}