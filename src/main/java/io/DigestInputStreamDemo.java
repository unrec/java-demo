package io;

import org.apache.commons.io.IOUtils;
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

    private static final String PATH1 = "src/main/resources/digest/sample_01.txt";
    private static final String PATH2 = "src/main/resources/digest/sample_02.txt";
    private static final String PATH3 = "src/main/resources/digest/sample_03.txt";
    private static final List<String> PATHS = List.of(PATH1, PATH2, PATH3);

    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {

        // get hash using DigestInputStream
        getViaDigest();

        // get hash using apache.codec library
        getViaLib();
    }

    public static void getViaDigest() throws NoSuchAlgorithmException, IOException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        for (String path : PATHS) {
            try (InputStream is = new FileInputStream(new File(Paths.get(path).toUri()));
                 DigestInputStream di = new DigestInputStream(is, md)) {
                // read data to compute digest
                di.readAllBytes();

                // convert digest to String of hex
                String fx = "%0" + (md.getDigestLength() * 2) + "x";
                System.out.println("digest = " + String.format(fx, new BigInteger(1, md.digest())));
            }
        }
    }

    public static void getViaLib() throws IOException {
        for (String path : PATHS) {
            try (InputStream is = new FileInputStream(new File(Paths.get(path).toUri()))) {
                String sha1Hex = org.apache.commons.codec.digest.DigestUtils.sha1Hex(is);
                System.out.println("sha1Hex = " + sha1Hex);
            }
        }
    }

    public static void getCombined() throws IOException, NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-1");

        for (String path : PATHS) {
            try (InputStream is = new FileInputStream(new File(Paths.get(path).toUri()))) {
                String sha1Hex = org.apache.commons.codec.digest.DigestUtils.sha1Hex(is);
                System.out.println("sha1Hex = " + sha1Hex);

                // stream was read by hex function so now it's empty
                System.out.println(IOUtils.toByteArray(is).length);
                System.out.println(new String(IOUtils.toByteArray(is)));
            }
        }
    }
}