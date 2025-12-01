def solve() -> tuple[int, int]:
    current = 50
    zeros, passing_over_zero = 0, 0

    with open('../../input/day01/day01.txt') as f:
        for line in f.readlines():
            direction = -1 if line[0] == "L" else 1
            turns = int(line[1:])

            if direction < 0:
                to_next_zero = current or 100
            else:
                to_next_zero = 100 - current

            current = (current + direction * turns) % 100

            if current == 0:
                zeros += 1
            if turns >= to_next_zero:
                passing_over_zero += (turns - to_next_zero) // 100 + 1

    return zeros, passing_over_zero


if __name__ == '__main__':
    print(solve())
