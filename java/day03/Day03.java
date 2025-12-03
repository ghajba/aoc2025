package day03;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.IntStream;

public class Day03 {
    static void main() {
        List<String> lines = readLines();

        long sum = lines.stream().mapToLong(batteries -> maxJoltage(batteries, 2)).sum();
        System.out.printf("Sum (2-digit): %d%n", sum); // 16858

        long sum12 = lines.stream().mapToLong(batteries -> maxJoltage(batteries, 12)).sum();
        System.out.printf("Sum (12-digit): %d%n", sum12); // 167549941654721
    }

    static long maxJoltage(String batteries, int length) {

        int current = length;
        long total = 0;
        int idx = 0;
        while (current > 0) {
            String toProcess = batteries.substring(idx);

            int maxIdx = IntStream.range(0, toProcess.length() - current + 1)
                .reduce((i, j) -> toProcess.charAt(i) >= toProcess.charAt(j) ? i : j)
                .orElse(0);

            char max = toProcess.charAt(maxIdx);
            total += (long) ((max - '0') * Math.pow(10, current - 1));
            current--;
            idx += maxIdx + 1;
        }

        return total;
    }

    private static List<String> readLines() {
        List<String> lines;

        try (FileReader fileReader = new FileReader(new File("input/day03/day03.txt"))) {
            lines = fileReader.readAllLines();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return lines;
    }
}
