package io;

import java.io.ByteArrayInputStream;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ThreadLocalRandom;

public class ByteArrayDemo {
    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[1024];
        ThreadLocalRandom.current().nextBytes(bytes);
        int counter = 0;

        InputStream input = new ByteArrayInputStream(bytes);
        CharArrayWriter output = new CharArrayWriter();

        int data = input.read();
        while (data != -1) {
            counter++;
            if (data > 97 && data < 122) output.write(data);
            data = input.read();
        }
        char[] chars = output.toCharArray();
        output.close();
        System.out.println("counter - " + counter);
        System.out.println(chars);
    }
}