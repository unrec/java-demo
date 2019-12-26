package io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipeDemo {
    public static void main(String[] args) throws IOException {

        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    output.write("Hello world, pipe!".getBytes());
                } catch (IOException e) {
                }
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                StringBuilder message = new StringBuilder();
                try {
                    int data = input.read();
                    while (data != -1) {
                        message.append((char) data).append(" ");
                        data = input.read();
                    }
                } catch (IOException e) {
                } finally {
                    System.out.println(message.toString());
                }
            }
        });

        thread1.start();
        thread2.start();
    }
}