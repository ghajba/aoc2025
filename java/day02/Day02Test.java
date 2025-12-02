package day02;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Day02Test {

    @Test
    public void invalidLengthReturnsFalse() {
        assertFalse(Day02.isInvalid("1234567890"));
    }

    @Test
    public void splitStringIntoTwoHalves() {
        String id = "1234567890123456";
        String first = id.substring(0, id.length() / 2);
        String second = id.substring(id.length() / 2);
        assertEquals("12345678", first);
        assertEquals("90123456", second);
    }

    @ParameterizedTest
    @MethodSource("idProvider")
    void testIsInvalid(String id, boolean expected) {
        assertEquals(expected, Day02.isInvalid(id));
    }

    private static Stream<Arguments> idProvider() {
        return Stream.of(
            Arguments.of("1212", true),
            Arguments.of("1234", false),
            Arguments.of("12345", false),
            Arguments.of("1234567890", false)
        );
    }

    @ParameterizedTest
    @MethodSource("idProviderSecond")
    void testIsInvalidSecond(String id, boolean expected) {
        assertEquals(expected, Day02.isInvalidSecond(id));
    }

    private static Stream<Arguments> idProviderSecond() {
        return Stream.of(
            Arguments.of("1212", true),
            Arguments.of("11111", true),
            Arguments.of("12341234", true),
            Arguments.of("123123123", true),
            Arguments.of("1212121212", true),
            Arguments.of("1234567890", false)
        );
    }

    @ParameterizedTest
    @MethodSource("splitToSizeProvider")
    void testSplitToSize(String id, int size, String[] expected) {
        assertTrue(Objects.deepEquals(expected, Day02.splitToSize(id, size)));
    }

    private static Stream<Arguments> splitToSizeProvider() {
        return Stream.of(
            Arguments.of("2", 1, new String[] {"2"}),
            Arguments.of("2234", 2, new String[] {"22", "34"}),
            Arguments.of("12345", 1, new String[] {"1", "2", "3", "4", "5"}),
            Arguments.of("1234567890", 5, new String[] {"12345", "67890"})
        );
    }
}