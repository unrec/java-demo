package io;

import java.io.*;

public class MD5HexDemo {
    public static void main(String[] args) throws IOException {
        String filePath = "src/main/resources/file.csv";
        File file = new File(filePath);
        try (InputStream is = new BufferedInputStream(new FileInputStream(file))) {
            String md5Hex = org.apache.commons.codec.digest.DigestUtils.md5Hex(is);
            System.out.println(md5Hex);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}