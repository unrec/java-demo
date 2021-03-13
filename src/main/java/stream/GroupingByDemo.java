package stream;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupingByDemo {

    public static void main(String[] args) {
        List<Custom> list = getListOfCustoms();

        Map<? extends Class<? extends Custom>, List<String>> collect = list.stream()
                .collect(Collectors.groupingBy(Custom::getClass, Collectors.mapping(Custom::getType, Collectors.toList()
                )));

        collect.forEach((k, v) -> System.out.println(String.format("Key: %s, value: %s", k, v)));
    }

    private static List<Custom> getListOfCustoms() {
        return List.of(
                new Custom1("cat"),
                new Custom1("tom"),
                new Custom2("num"),
                new Custom3("form")
        );
    }

    @Getter
    @AllArgsConstructor
    abstract static class Custom {
        private String type;
    }

    private static class Custom1 extends Custom {
        public Custom1(String type) {
            super(type);
        }
    }

    private static class Custom2 extends Custom {
        public Custom2(String type) {
            super(type);
        }
    }

    private static class Custom3 extends Custom {
        public Custom3(String type) {
            super(type);
        }
    }
}