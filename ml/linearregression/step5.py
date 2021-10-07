import matplotlib.pyplot as plt
import pandas as pd

dataset = pd.read_csv("salary_data.csv")
x = dataset.iloc[:, :-1].values
y = dataset.iloc[:, 1].values

plt.figure(1)
plt.scatter(x, y, color = "red")
plt.title("Salary vs Experience")
plt.xlabel("Years of Experience")
plt.ylabel("Salary")
plt.show()