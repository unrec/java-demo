package date;

import org.assertj.core.api.Assertions;
import java.time.LocalDateTime;

public class LocalDateComparingDemo {
    public static void main(String[] args) {
        LocalDateTime localDate1 = LocalDateTime.parse("2020-07-15T15:24:30.620024300");
        LocalDateTime localDate2 = LocalDateTime.parse("2020-07-15T15:24:30.620024");

        boolean isEquals = localDate1.equals(localDate2);
        System.out.println("isEquals = " + isEquals);

        Event event1 = new Event(localDate1, "Some Event");
        Event event2 = new Event(localDate2, "Some Event");

//         will fail
//        Assertions.assertThat(event1).isEqualTo(event2);

//        will pass
        Assertions.assertThat(event1)
                .usingRecursiveComparison()
                .ignoringFields("date")
                .isEqualTo(event2);
    }

    public static class Event {
        public Event(LocalDateTime date, String description) {
        }
    }
}