import math
from scipy import stats

full_data = [
    87, 54, 35, 53, 67, 45, 64, 48, 39, 29, 45, 90, 97, 47, 45, 45, 78, 74, 90, 67, 57, 58, 87, 52, 37,
    59, 63, 46, 68, 67, 67, 45, 23, 90, 87, 84, 23, 45, 46, 48, 65, 89, 45, 67, 85, 55, 35, 54, 67, 45,
    67, 67, 67, 45, 29, 99, 87, 84, 23, 45, 46, 48, 65, 89, 45, 67, 87, 54, 35, 53, 67, 45, 67, 62, 67,
    45, 23, 90, 87, 84, 23, 45, 46, 48, 47, 87, 42, 78, 87, 54, 35, 53, 67, 45, 67, 67, 67, 45, 23, 90
]

data = [
    59, 63, 46, 68, 67, 67, 67, 67, 45, 29,
    48, 65, 89, 85, 55, 67, 57, 58, 23, 90
]

n = len(data)
sum_d = sum(data)
avg = sum_d / n
print("avg: ", avg)

sum_x2 = sum([math.pow(x, 2) for x in data])
sum_x_2 = math.pow(sum(data), 2)
s2 = (n * sum_x2 - sum_x_2) / (n * (n - 1))
print("varian: ", s2)

s = math.sqrt(s2)
print("stdev: ", s)

full_avg = sum(full_data) / len(full_data)
stat = (abs(full_avg - avg)) / (s / math.sqrt(n))
_, pv = stats.ttest_1samp(data, full_avg)
print("full avg: ", full_avg)
print("stat: ", stat)
print("pvalue: ", pv)