package io.file;

import org.apache.commons.io.FilenameUtils;

// WINDOWS		\
// LINUX		/

public class SeparatorDemo {
    public static void main(String[] args) {
        String winPath = "C:\\tools\\apache";
        String linuxPath = FilenameUtils.separatorsToUnix(winPath);

        System.out.println("original: " + winPath);
        System.out.println("linux: " + linuxPath);
    }
}