package day05;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.LongStream;

public class Day05 {

    static void main() {
        Inventory inventory = part1("input/day05/day05.txt");
//        Inventory inventory = part1("input/day05/test.txt");
        System.out.println(inventory.ingredients().size());
        System.out.println(inventory.ingredients.stream().filter(inventory.freshIds()::contains).count()); // 694
    }

    static Inventory part1(String fileName) {
        try {
            List<String> lines = Files.readAllLines(new File(fileName).toPath());
            Iterator<String> iterator = lines.iterator();
            List<Range> freshIds = new LinkedList<>();
            Set<Long> ingredients = new HashSet<>();
            while (iterator.hasNext()) {
                String line = iterator.next();
                if(line == null || line.trim().isEmpty()) {
                    System.out.println("Id ranges parsed");
                    break;
                }
                String[] split = line.split("-");
                var range = new Range(Long.parseLong(split[0]), Long.parseLong(split[1]));
                freshIds.add(range);
            }
            iterator.forEachRemaining(line -> {
                ingredients.add(Long.parseLong(line));
            });
            freshIds.sort(Comparator.comparingLong(Range::start));
            return new Inventory(new RangeSet(freshIds), ingredients);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    record Inventory(RangeSet freshIds, Set<Long> ingredients) {
    }
    record RangeSet(List<Range> ranges){
        public boolean contains(Long number) {
            for(Range range : ranges) {
                if(range.contains(number)) {
                    return true;
                }
            }
            return false;
        }
    }
    record Range(Long start, Long end) {
        public boolean contains(Long number) {
            return number >= start && number <= end;
        }
    }
}
