package regex;

import org.junit.jupiter.api.Test;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexForSpacesTest {

    private static final String REGEX = "^\\s|\\s{2,}|\\s$";
    private static final Pattern PATTERN = Pattern.compile(REGEX);

    private static final String CORRECT_STRING = "No extra spaces";
    private static final String WRONG_STRING = " There  are too   many spaces ";
    private static final String LEADING_SPACE_STRING = " Leading space";
    private static final String TRAILING_SPACE_STRING = "Trailing space ";
    private static final String EXTRA_SPACES_STRING = "There  are extra spaces";

    @Test
    void lookingAt_CorrectString_NoMatching() {
        Matcher matcher = PATTERN.matcher(CORRECT_STRING);
        assertFalse(matcher.lookingAt());
    }

    @Test
    void lookingAt_WrongString_Matching() {
        Matcher matcher = PATTERN.matcher(WRONG_STRING);
        assertTrue(matcher.lookingAt());
    }

    @Test
    void lookingAt_LeadingSpace_Matching() {
        Matcher matcher = PATTERN.matcher(LEADING_SPACE_STRING);
        assertTrue(matcher.lookingAt());
    }

    @Test
    void lookingAt_TrailingSpace_NoMatching() {
        Matcher matcher = PATTERN.matcher(TRAILING_SPACE_STRING);
        assertFalse(matcher.lookingAt());
    }

    @Test
    void lookingAt_ExtraSpaces_NoMatching() {
        Matcher matcher = PATTERN.matcher(EXTRA_SPACES_STRING);
        assertFalse(matcher.lookingAt());
    }

    @Test
    void find_CorrectString_NoMatching() {
        Matcher matcher = PATTERN.matcher(CORRECT_STRING);
        assertFalse(matcher.find());
    }

    @Test
    void find_WrongString_Matching() {
        Matcher matcher = PATTERN.matcher(WRONG_STRING);
        assertTrue(matcher.find());
    }

    @Test
    void find_LeadingSpace_Matching() {
        Matcher matcher = PATTERN.matcher(LEADING_SPACE_STRING);
        assertTrue(matcher.find());
    }

    @Test
    void find_TrailingSpace_Matching() {
        Matcher matcher = PATTERN.matcher(TRAILING_SPACE_STRING);
        assertTrue(matcher.find());
    }

    @Test
    void find_ExtraSpaces_Matching() {
        Matcher matcher = PATTERN.matcher(EXTRA_SPACES_STRING);
        assertTrue(matcher.find());
    }
}