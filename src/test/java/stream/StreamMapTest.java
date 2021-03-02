package stream;

import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class StreamMapTest {

    @Test
    void MapNullElement_NullPointerException() {

        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        integerList.add(null);

        assertThrows(NullPointerException.class, () -> integerList.stream()
                .map(BigInteger::valueOf)
                .collect(Collectors.toList()));
    }

    @Test
    void MapNullElement() {

        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        integerList.add(null);

        assertThrows(NullPointerException.class, () -> integerList.stream()
                .filter(Objects::nonNull)
                .map(BigInteger::valueOf)
                .collect(Collectors.toList()));
    }
}