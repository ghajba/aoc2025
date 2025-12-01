void main(String[] args) {
    File file = new File("java/day01/day01.txt");
    try (FileReader fileReader = new FileReader(file)) {
        int zeros = 0;
        int current = 50;
        for (String line : fileReader.readAllLines()) {
            int turns = Integer.parseInt(line.substring(1)) % 100;
            if (line.startsWith("L")) {
                current -= turns;
                if (current < 0) {
                    current = current + 100;
                }
            } else {
                current += turns;
                if (current >= 100) {
                    current = current - 100;
                }
            }

            if (current == 0) {
                zeros++;
            }
            System.out.printf("%s --> %d%n", line, current);
        }
        System.out.println("Zeros: " + zeros);
    } catch (IOException e) {
        throw new RuntimeException(e);
    }
}