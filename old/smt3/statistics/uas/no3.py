import math
from scipy import stats

data = [
    [18.80, 17.20],
    [21.30, 20.30],
    [14.50, 14.20],
    [17.70, 18.50],
    [26.80, 28.00],
    [24.00, 24.80],
    [21.80, 20.30],
    [23.00, 25.40],
    [28.30, 27.50],
    [20.50, 19.70]
]

n = 10
data_x = [x[0] for x in data]
data_y = [x[1] for x in data]
sum_xy = sum([x[0] * x[1] for x in data])
sum_x = sum(data_x)
avg_x = sum_x / n
sum_y = sum(data_y)
avg_y = sum_y / n
sum_x2 = sum([math.pow(x, 2) for x in data_x])
sum_x_2 = math.pow(sum_x, 2)
sum_y2 = sum([math.pow(y, 2) for y in data_y])
sum_y_2 = math.pow(sum_y, 2)

# Getting r.
r = (n * sum_xy - sum_x * sum_y) / math.sqrt(
    (n * sum_x2 - math.pow(sum_x, 2)) * (n * sum_y2 - sum_y_2)
)
print("r: {}".format(r))

# Getting t statistic.
stat = r * math.sqrt(n - 2) / math.sqrt(1 - math.pow(r, 2))
print("t: {}".format(stat))

# Getting p-value.
_, pv = stats.pearsonr(data_x, data_y)
print("p-value: {}".format(pv))

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

print(rel)

# Linear regression.
b1 = (n * sum_xy - sum_x * sum_y) / (n * sum_x2 - sum_x_2)
b0 = avg_y - b1 * avg_x
print("b1: ", b1)
print("b0: ", b0)

r2 = math.pow(r, 2)
print("model: {} + {} x".format(b0, r2))