package stream;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class GroupingWithMaxByDemo {

    public static void main(String[] args) {
        List<House> houses = List.of(
                new House(1, "Bedford St", 90, LocalDate.of(1994, 1, 2)),
                new House(1, "Bedford St", 90, LocalDate.of(1999, 1, 2)),
                new House(1, "Bedford St", 90, LocalDate.of(2004, 1, 2)),
                new House(2, "5th Ave", 888, LocalDate.of(2019, 1, 4)),
                new House(2, "5th Ave", 888, LocalDate.of(1968, 1, 11)),
                new House(2, "5th Ave", 888, LocalDate.of(1885, 1, 11)));

        Map<Integer, Optional<House>> collect = houses.stream()
                .collect(Collectors.groupingBy(House::getId, Collectors.maxBy(
                        Comparator.comparing(House::getDate))));

        var actualList = collect.values().stream()
                .map(Optional::get)
                .collect(Collectors.toList());

        System.out.println("Actual list:");
        actualList.forEach(System.out::println);
    }

    @Data
    @AllArgsConstructor
    private static class House {
        Integer id;
        String streetName;
        Integer houseNumber;
        LocalDate date;
    }
}