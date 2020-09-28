package date;

import java.time.LocalDate;

import static java.time.temporal.ChronoUnit.YEARS;

public class LocalDateDifferenceDemo {
    public static void main(String[] args) {
        LocalDate firstDate = LocalDate.of(2010, 12, 6);
        LocalDate secondDate = LocalDate.of(2011, 12, 6);
        LocalDate today = LocalDate.of(2019, 12, 6);

        long yearsBetween = YEARS.between(firstDate, secondDate);
        long yearsUpToday = YEARS.between(firstDate, today);
        System.out.println("Years between 1st and 2nd dates: " + yearsBetween); // should be 1
        System.out.println("Years between 1st date and now: " + yearsUpToday); // should be 9
    }
}