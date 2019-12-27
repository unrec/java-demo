package io;

import io.zip.UnzipUtility;
import java.io.File;
import java.io.IOException;

public class FolderDeleteDemo {
    public static final String ZIP_PATH = "src/main/resources/temp.zip";
    public static final String ZIP_DESTINATION = "src/main/resources/unzipped";

    public static void main(String[] args) {
        unzipFolder();
        File directory = new File(ZIP_DESTINATION);
        try {
            deleteDirectoryRecursively(directory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void unzipFolder() {
        UnzipUtility unZipper = new UnzipUtility();
        try {
            unZipper.unzip(ZIP_PATH, ZIP_DESTINATION);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static void deleteDirectoryRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            File[] entries = file.listFiles();
            if (entries != null) {
                for (File entry : entries) {
                    deleteDirectoryRecursively(entry);
                }
            }
        }
        if (!file.delete()) {
            throw new IOException("Failed to delete " + file);
        }
    }
}