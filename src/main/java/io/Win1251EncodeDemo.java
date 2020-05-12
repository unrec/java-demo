package io;

import java.io.*;

public class Win1251EncodeDemo {
    private static final String CSV_ORIGIN_PATH = "src/test/resources/correct_charset_input.csv";
    private static final String CSV_OUTPUT_PATH = "src/test/resources/correct_charset_output.csv";
    public static final String SELECTED_CHARSET = "windows-1251";

    public static void main(String[] args) throws IOException {
        try (
                Writer out = new OutputStreamWriter(new FileOutputStream(CSV_OUTPUT_PATH), SELECTED_CHARSET);
                InputStream inputStream = new FileInputStream(CSV_ORIGIN_PATH);
                ByteArrayOutputStream lines = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                lines.write(buffer, 0, length);
            }
            String strings = new String(lines.toByteArray(), SELECTED_CHARSET);
            System.out.println(strings);
            out.write(strings);
        }
    }
}