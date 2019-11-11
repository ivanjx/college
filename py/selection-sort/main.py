def main():
    numbers = [10, 11, 12, 0, 1, -100, 0]

    for i in range(len(numbers)):
        for j in range(i + 1, len(numbers)):
            if numbers[i] > numbers[j]:
                numbers[i], numbers[j] = numbers[j], numbers[i]

    print(numbers)


if __name__ == "__main__":
    main()