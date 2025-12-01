void main(String[] args) {
    File file = new File("input/day01/day01.txt");
    try (FileReader fileReader = new FileReader(file)) {
        int zeros = 0;
        int passingOverZero = 0;
        int current = 50;

        for (String line : fileReader.readAllLines()) {
            int toNextZero;
            int direction;
            int turns = Integer.parseInt(line.substring(1));

            if (line.startsWith("L")) {
                toNextZero = current == 0 ? 100 : current;
                direction = -1;
            } else {
                toNextZero = 100 - current;
                direction = 1;
            }

            current = (current + direction * turns) % 100;
            if (current < 0) {
                current += 100;
            }

            if (current == 0) {
                zeros++;
            }

            if (turns >= toNextZero) {
                passingOverZero += (turns - toNextZero) / 100 + 1;
            }

            //            System.out.printf("%s --> %d%n", line, current);
        }
        System.out.println("Zeros: " + zeros); // 1086
        System.out.println("Passing zero: " + passingOverZero); // 6268
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}