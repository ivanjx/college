def main():
    m1 = [
        [1, 2, 3],
        [3, 4, 5]
    ]

    m2 = [
        [1, 5, 9],
        [0, 1, 1]
    ]

    m3 = [
        [1, 2],
        [3, 4],
        [5, 6]
    ]

    result1 = []
    result2 = []

    # m1 + m2
    for i in range(len(m1)):
        result1.append([])
        
        for j in range(len(m1[i])):
            result1[i].append(m1[i][j] + m2[i][j])

    print(result1)


if __name__ == "__main__":
    main()