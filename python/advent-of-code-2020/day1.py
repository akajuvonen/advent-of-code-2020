INPUT = 'inputs/day1.txt'


def main():
    entries = set()
    with open(INPUT) as f:
        for line in f:
            entries.add(int(line.rstrip('\n')))

    for entry in entries:
        remainder = 2020 - entry
        if remainder in entries:
            print(entry * remainder)
            return


if __name__ == '__main__':
    main()
