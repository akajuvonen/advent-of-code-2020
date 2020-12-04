INPUT = 'inputs/day1.txt'


def main():
    entries = set()
    with open(INPUT) as f:
        for line in f:
            entries.add(int(line.rstrip('\n')))

    # two entries that sum up to 2020
    for entry in entries:
        remainder = 2020 - entry
        if remainder in entries:
            print(f'{entry} and {remainder} multiplied {entry * remainder}')
            break

    # three entries that sum up to 2020
    for first in entries:
        for second in entries:
            remainder = 2020 - first - second
            if remainder in entries:
                print(f'{first}, {second}, {remainder} multiplied: {first * second * remainder}')
                return


if __name__ == '__main__':
    main()
