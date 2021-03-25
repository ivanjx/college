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
    sum_x = sum(data_x)
    sum_y = sum(data_y)
    sum_x2 = sum(math.pow(x, 2) for x in data_x)
    sum_y2 = sum(math.pow(x, 2) for x in data_y)
    sum_xy = sum((x[0] * x[1]) for x in data)
    print("sum x: {}".format(sum_x))
    print("sum y: {}".format(sum_y))
    print("sum x2: {}".format(sum_x2))
    print("sum y2: {}".format(sum_y2))
    print("sum xy: {}".format(sum_xy))

    # Getting r.
    r = (n * sum_xy - sum_x * sum_y) / math.sqrt(
        (n * sum_x2 - math.pow(sum_x, 2)) * (n * sum_y2 - math.pow(sum_y, 2))
    )
    print("r: {}".format(r))

    # Getting t statistic.
    t = r * math.sqrt(n - 2) / math.sqrt(1 - math.pow(r, 2))
    print("t: {}".format(t))

    # Getting p-value.
    _, pv = stats.pearsonr(data_x, data_y)
    print("p-value: {}".format(pv))

    # Hypothesis.
    if pv == 0:
        print("summary: Ho approved, Ha rejected.")
    else:
        print("summary: Ho rejected, Ha approved.")

    # Getting relation.
    rel = ""

    if r >= 0.8:
        rel = "very strong"
    elif r >= 0.6:
        rel = "strong"
    elif r >= 0.4:
        rel = "medium"
    elif r >= 0.2:
        rel = "low"
    else:
        rel = "very low"
    
    print("relation level:", rel)

    # Generating plot.
    print("Plotting...")
    plt.scatter(data_x, data_y)
    plt.xlabel(label1)
    plt.ylabel(label2)
    plt.show()

    # Done.
    print("Done.")


main(sys.argv[1:])