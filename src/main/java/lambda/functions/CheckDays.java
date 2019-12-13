package lambda.functions;

import java.time.DayOfWeek;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import static java.time.DayOfWeek.SATURDAY;
import static java.time.DayOfWeek.SUNDAY;

public class CheckDays implements Predicate {
    @Override
    public boolean test(Object o) {
        if (!(o instanceof DayOfWeek)) return false;
        DayOfWeek day = (DayOfWeek) o;
        return day == SATURDAY || day == SUNDAY;
    }

    public static List<DayOfWeek> filter(List<DayOfWeek> days,
                                         Predicate<DayOfWeek> predicate) {
        return days.stream()
                .filter(predicate)
                .collect(Collectors.<DayOfWeek>toList());
    }
} // end of class