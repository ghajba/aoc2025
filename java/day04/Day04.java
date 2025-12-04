package day04;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day04 {
    static String[][] map;

    static int[][] neighbors;

    static int gridSize;

    static void main() {

        try {
            List<String> lines = Files.readAllLines(new File("input/day04/day04.txt").toPath());

            gridSize = lines.size();
            map = new String[gridSize][];

            for (int x = 0; x < gridSize; x++) {
                String line = lines.get(x);
                map[x] = line.split("");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        int accessible = getAccessible();

        System.out.printf("Accessible rolls: %d%n", accessible); // 1349

        int allRemovable = 0;
        int removable;
        do {
            removable = getRemovable();
            allRemovable += removable;
        } while (removable != 0);
        System.out.printf("Removable rolls: %d%n", allRemovable); // 8277
    }

    private static int getRemovable() {
        int removable = 0;

        initNeighborMap();

        for (int x = 0; x < neighbors.length; x++) {
            for (int y = 0; y < neighbors[x].length; y++) {
                if (Objects.equals(map[x][y], "@") && neighbors[x][y] < 4) {
                    removable++;
                    map[x][y] = ".";
                }
            }
        }
        return removable;
    }

    private static void initNeighborMap() {
        initNeighbors();

        for (int x = 0; x < map.length; x++) {
            for (int y = 0; y < map[x].length; y++) {
                if (Objects.equals(map[x][y], "@")) {
                    addNeighbors(x, y);
                }
            }
        }
    }

    private static int getAccessible() {
        int accessible = 0;

        initNeighborMap();

        for (int x = 0; x < neighbors.length; x++) {
            for (int y = 0; y < neighbors[x].length; y++) {
                if (Objects.equals(map[x][y], "@") && neighbors[x][y] < 4) {
                    accessible++;
                }
            }
        }
        return accessible;
    }

    private static void initNeighbors() {
        neighbors = new int[gridSize][gridSize];
    }

    private static void addNeighbors(int x, int y) {
        addNeighbor(x, y - 1);
        addNeighbor(x, y + 1);
        addNeighbor(x - 1, y);
        addNeighbor(x + 1, y);
        addNeighbor(x - 1, y - 1);
        addNeighbor(x - 1, y + 1);
        addNeighbor(x + 1, y - 1);
        addNeighbor(x + 1, y + 1);
    }

    private static void addNeighbor(int x, int y) {
        try {
            if (map[x][y].equals("@")) {
                neighbors[x][y]++;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            // ignore
        }
    }
}
