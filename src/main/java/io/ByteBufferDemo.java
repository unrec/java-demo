package io;

import java.io.*;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class ByteBufferDemo {
    public static final int BUFFER_SIZE = 8;

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[13];
        ThreadLocalRandom.current().nextBytes(bytes);
        System.out.println(Arrays.toString(bytes));

        ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
        int counter = 0;
        int data;

        try (InputStream input = new ByteArrayInputStream(bytes);
             OutputStream output = new FileOutputStream("src/main/java/resources/buffer.txt")) {

            data = input.read();
            while (data != -1) {
                for (int i = 0; i < BUFFER_SIZE; i++) {
                    buffer.put((byte) data);
                    counter++;
                    data = input.read();
                    if (data == -1) break;
                }
                output.write(buffer.array(), 0, buffer.position());
                buffer.clear();
            }
        }
        System.out.println("byte counter = " + counter);
        System.out.println("Copying is finished.");
    }
}