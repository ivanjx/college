import sys
import csv
import math
import matplotlib.pyplot as plt
from scipy import stats

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
    d = [x[0] - x[1] for x in data]
    avg_d = sum(d) / n
    sum_di_d_2 = sum([math.pow(x - avg_d, 2) for x in d])
    sd = math.sqrt(sum_di_d_2 / (n - 1))
    t = avg_d / (sd / math.sqrt(n))
    _, pv = stats.ttest_rel(data_x, data_y)
    print("t: {}".format(t))
    print("p-value: {}".format(pv))

    # Generating plot.
    print("Plotting...")
    plt.scatter(data_x, data_y)
    plt.xlabel(label1)
    plt.ylabel(label2)
    plt.show()

    # Done.
    print("Done.")


main(sys.argv[1:])