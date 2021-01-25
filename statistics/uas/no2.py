import math
from scipy import stats

data_x = [
    157.4,
    167.8,
    171.2,
    174.7,
    177.4,
    157.7,
    168.4,
    172.4,
    175.1,
    178.8
]

data_y = [
    165.4,
    167.8,
    175.2,
    179.7,
    172.4,
    149.7,
    167.4,
    17.4,
    168.1,
    180.8
]

n = 10

avg_x = sum(data_x) / n
sum_x2 = sum([math.pow(x, 2) for x in data_x])
sum_x_2 = math.pow(sum(data_x), 2)
s2_x = (n * sum_x2 - sum_x_2) / (n * (n - 1))

avg_y = sum(data_y) / n
sum_y2 = sum([math.pow(x, 2) for x in data_y])
sum_y_2 = math.pow(sum(data_y), 2)
s2_y = (n * sum_y2 - sum_y_2) / (n * (n - 1))

s2_p = ((n - 1) * s2_x + (n - 1) * s2_y) / (n + n - 2)
s_p = math.sqrt(s2_p)
stat = abs(avg_x - avg_y) / (s_p * math.sqrt(1 / n + 1 / n))

_, pv = stats.ttest_ind(data_x, data_y)
print("stat: ", stat)
print("pvalue: ", pv)