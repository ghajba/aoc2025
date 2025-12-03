package day03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    @ParameterizedTest
    @MethodSource("batteriesProvider")
    void maxJoltage(String battery, int expected) {
        assertEquals(expected, Day03.maxJoltage(battery));
    }

    private static Stream<Arguments> batteriesProvider() {
        return Stream.of(
            Arguments.of("23", 23),
            Arguments.of("987654321111111", 98),
            Arguments.of("811111111111119", 89),
            Arguments.of("234234234234278", 78),
            Arguments.of("818181911112111", 92)
        );
    }
}