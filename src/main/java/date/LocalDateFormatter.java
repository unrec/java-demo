package date;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateFormatter {
    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();
        System.out.println("Before : " + now);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formatDateTime = now.format(formatter);
        String currentTime = LocalDate.now().format(formatter);
        System.out.println("After : " + formatDateTime);
    }
}
