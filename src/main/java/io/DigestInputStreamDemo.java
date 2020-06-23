package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.nio.file.Paths;
import java.security.DigestInputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

public class DigestInputStreamDemo {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String path1 = "src/main/resources/digest/sample_01.txt";
        String path2 = "src/main/resources/digest/sample_02.txt";
        String path3 = "src/main/resources/digest/sample_03.txt";
        List<String> paths = List.of(path1, path2, path3);

        // get hash using DigestInputStream
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        for (String path : paths) {
            try (InputStream is = new FileInputStream(new File(Paths.get(path).toUri()));
                 DigestInputStream di = new DigestInputStream(is, md)) {
                di.readAllBytes();

                String fx = "%0" + (md.getDigestLength() * 2) + "x";
                System.out.println("digest = " + String.format(fx, new BigInteger(1, md.digest())));
            }
        }

        // get hash using apache.codec library
        for (String path : paths) {
            try (InputStream is = new FileInputStream(new File(Paths.get(path).toUri()))) {
                String sha1Hex = org.apache.commons.codec.digest.DigestUtils.sha1Hex(is);
                System.out.println("sha1Hex = " + sha1Hex);
            }
        }
    }
}