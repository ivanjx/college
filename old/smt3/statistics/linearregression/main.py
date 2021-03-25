import sys
import csv
import math
import matplotlib.pyplot as plt

def main(args):
    if len(args) == 0:
        raise Exception("Usage: main.py <source csv>")

    # Getting input.
    input_path = str(args[0]).replace("\"", "")

    # Reading input.
    label1 = ''
    label2 = ''
    data = []

    with open(input_path) as input_f:
        reader = csv.reader(input_f, delimiter=";")

        for row in reader:
            if not label1 and not label2:
                # Getting labels.
                label1 = row[0]
                label2 = row[1]
                continue

            # Getting data.
            data.append([
                float(row[0].replace(",", ".")), 
                float(row[1].replace(",", "."))
            ])

    # Printing acquired data.
    print("Data:")
    print("{}\t{}".format(label1, label2))

    for d in data:
        print("{}\t\t\t{}".format(d[0], d[1]))

    print()
    n = len(data)
    print("n: {}".format(n))

    # Getting sums.
    data_x = [x[0] for x in data]
    data_y = [x[1] for x in data]
    sum_xy = sum([x[0] * x[1] for x in data])
    sum_x = sum(data_x)
    avg_x = sum_x / n
    sum_y = sum(data_y)
    avg_y = sum_y / n
    sum_x2 = sum([math.pow(x, 2) for x in data_x])
    sum_x_2 = math.pow(sum_x, 2)
    b1 = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x_2)
    b0 = avg_y - b1 * avg_x
    print("b1: {}".format(b1))
    print("b0: {}".format(b0))

    sum_y2 = sum([math.pow(y, 2) for y in data_y])
    sum_y_2 = math.pow(sum_y, 2)
    r2 = math.pow((
        n * sum_xy - sum_x * sum_y
    ) / (
        math.sqrt((n * sum_x2 - sum_x_2) * (n * sum_y2 - sum_y_2))
    ), 2)

    print("R2: {} %".format(r2 * 100))

    # Generating plot.
    print("Plotting...")
    plt.scatter(data_x, data_y)
    plt.xlabel(label1)
    plt.ylabel(label2)
    plt.show()

    # Done.
    print("Done.")


main(sys.argv[1:])