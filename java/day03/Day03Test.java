package day03;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {

    @ParameterizedTest
    @MethodSource("batteriesProvider")
    void maxJoltage(String battery, long expected) {
        assertEquals(expected, Day03.maxJoltage(battery, 2));
    }

    @ParameterizedTest
    @MethodSource("batteries12Provider")
    void maxJoltage12(String battery, long expected) {
        assertEquals(expected, Day03.maxJoltage(battery, 12));
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

    private static Stream<Arguments> batteries12Provider() {
        return Stream.of(
            Arguments.of("987654321111111", 987654321111L),
            Arguments.of("811111111111119", 811111111119L),
            Arguments.of("234234234234278", 434234234278L),
            Arguments.of("818181911112111", 888911112111L)
        );
    }
}