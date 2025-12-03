package day03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class Day03 {
    static void main() {
        List<String> lines = readLines();

        int sum = lines.stream().mapToInt(Day03::maxJoltage).sum();
        System.out.printf("Sum (2-digit): %d%n", sum); // 16858
    }

    static int maxJoltage(String batteries) {

        int maxIdx = IntStream.range(0, batteries.length()-1)
            .reduce((i, j) -> batteries.charAt(i) >= batteries.charAt(j) ? i : j)
            .orElse(0);

        char max = batteries.charAt(maxIdx);
        int total = (max - '0') * 10;

        return total + batteries.substring(maxIdx + 1).chars().mapToObj(c -> c - '0').max(Integer::compare).orElse(0);
    }

    private static List<String> readLines() {
        List<String> lines;

        try (FileReader fileReader = new FileReader(new File("input/day03/test.txt"))) {
            lines = fileReader.readAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
