package regex;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class NonBreakingSpaceTest {

    private static final String NON_BREAKING_SPACE = " ";
    private static final String INPUT_STRING = "Test String";
    private static final String STRING_WITH_SPACES = "Test   String";

    @Test
    void removeNonBreakingSpace() {

        //given
        String string = INPUT_STRING + NON_BREAKING_SPACE;

        //when
        String result = string.replaceAll("\\h", " ");

        //then
        assertFalse(result.contains(NON_BREAKING_SPACE));
    }

    @Test
    void filterExtraSpaces() {

        //given
        String string = " " + INPUT_STRING + NON_BREAKING_SPACE + "  ";

        //when
        String result = string.replaceAll("\\h", " ").replaceAll("\\s+", " ").trim();

        //then
        assertFalse(result.contains(NON_BREAKING_SPACE));
        assertEquals(result, INPUT_STRING);
    }

    @Test
    void filterExtraSpacesInsideString() {

        //given
        String string = " " + STRING_WITH_SPACES + NON_BREAKING_SPACE + "  ";

        //when
        String result = string.replaceAll("\\h", " ").replaceAll("\\s+", " ").trim();

        //then
        assertFalse(result.contains(NON_BREAKING_SPACE));
        assertEquals(result, INPUT_STRING);
    }
}