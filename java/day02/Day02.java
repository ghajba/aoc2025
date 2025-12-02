package day02;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Day02 {
    static void main() {
        try (FileReader fileReader = new FileReader(new File("input/day02/day02.txt"))) {
            int invalidCount = 0;
            long invalidSum = 0;
            int secondInvalidCount = 0;
            long secondInvalidSum = 0;

            for (String range : fileReader.readAllAsString().split(",")) {
                String[] bounds = range.split("-");
                long start = Long.parseLong(bounds[0]);
                long end = Long.parseLong(bounds[1]);
                for (long i = start; i <= end; i++) {
                    if (isInvalid(String.valueOf(i))) {
                        invalidCount++;
                        invalidSum += i;
                    }
                    if (isInvalidSecond(String.valueOf(i))) {
                        secondInvalidCount++;
                        secondInvalidSum += i;
                    }
                }

            }
            // First part: 23039913998
            System.out.printf("Invalid count: %d; invalid sum: %d%n", invalidCount, invalidSum);
            // Second part: 35950619148
            System.out.printf("Invalid count: %d; invalid sum: %d%n", secondInvalidCount, secondInvalidSum);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static boolean isInvalid(String id) {
        if (id.length() % 2 != 0) {
            return false;
        }
        String first = id.substring(0, id.length() / 2);
        String second = id.substring(id.length() / 2);
        return Objects.equals(first, second);
    }

    static boolean isInvalidSecond(String id) {
        int length = id.length();
        outer:
        for (int i = length / 2; i > 0; i--) {
            String[] parts = splitToSize(id, i);
            inner:
            for (int j = 0; j <= parts.length - 2; j++) {
                String a = parts[j];
                String b = parts[j + 1];
                if (!Objects.equals(a, b)) {
                    continue outer;
                }
            }
            return true;
        }
        return false;
    }

    static String[] splitToSize(String id, int i) {
        return id.split("(?<=\\G.{" + i + "})");
    }
}
