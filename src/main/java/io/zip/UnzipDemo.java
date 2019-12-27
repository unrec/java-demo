package io.zip;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class UnzipDemo {
    public static final String ZIP_PATH = "src/main/resources/temp.zip";
    public static final String ZIP_DESTINATION = "src/main/resources/unzipped";

    public static void main(String[] args) {

        // using zip4j
        try {
            ZipFile zipFile = new ZipFile(ZIP_PATH);
            zipFile.extractAll(ZIP_DESTINATION);
        } catch (ZipException e) {
            e.printStackTrace();
        }

        // using UnzipUtility
        UnzipUtility unZipper = new UnzipUtility();
        try {
            unZipper.unzip(ZIP_PATH, ZIP_DESTINATION);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}