package lambda.functions;

import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;
import static lambda.functions.CheckDays.filter;

public class PredicateDemo {

    public static void main(String[] args) {
        List<DayOfWeek> days = Arrays.asList(DayOfWeek.values());
        CheckDays checker = new CheckDays();
        Predicate<DayOfWeek> lambda = (value) -> value == SATURDAY || value == SUNDAY;

        for (DayOfWeek day : days) {
            System.out.println(day + "- is weekend? - " + checker.test(day));
//            System.out.println(day + "- is weekend? - " + lambda.test(day));  // using lambda
        }
        System.out.println("Weekend days: " + filter(days, lambda));
    }
} // end of class