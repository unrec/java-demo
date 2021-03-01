package stream;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasSize;

class StreamFilterTest {

    @Test
    void filterEmptyStrings() {

        //given
        List<String> strings = Arrays.asList("", "one", " ", "two", "", "three", "");

        //when
        List<String> filtered = strings.stream()
                .distinct()
                .filter(StringUtils::isNotBlank)
                .collect(Collectors.toList());

        //then
        assertThat(filtered, hasSize(3));
    }
}