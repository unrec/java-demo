package io.populate;

import lombok.NoArgsConstructor;
import java.io.*;

@NoArgsConstructor
public class FilePopulator {

    public static final String SELECTED_CHARSET = "windows-1251";

    public void populate(String origin, String destination, int copyTimes) {
        try (
                Writer out = new OutputStreamWriter(new FileOutputStream(destination), SELECTED_CHARSET);
                InputStream inputStream = new FileInputStream(origin);
                ByteArrayOutputStream lines = new ByteArrayOutputStream()) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                lines.write(buffer, 0, length);
            }
            String strings = new String(lines.toByteArray(), SELECTED_CHARSET);
            System.out.println(strings);

            for (int i = 0; i < copyTimes; i++) {
                out.write(strings);
            }
        } catch (Exception e) {
//            log.warn(e.getMessage());
        }
    }
}