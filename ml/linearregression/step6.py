import matplotlib.pyplot as plt
import pandas as pd
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split

dataset = pd.read_csv("salary_data.csv")
x = dataset.iloc[:, :-1].values
y = dataset.iloc[:, 1].values

x_train, x_test, y_train, y_test = train_test_split(x, y, test_size=1/3, random_state=0)

regressor = LinearRegression()
regressor.fit(x_train, y_train)

akurasi = regressor.score(x_train, y_train)
print("Akurasi dari model adalah:", akurasi)
print("Nilai gradient:", regressor.intercept_)
print("Nilai koefisien:", regressor.coef_)

pred = regressor.predict(x_train)

plt.figure(1)
plt.scatter(x_train, y_train, color = "red")
plt.plot(x_train, pred, color = "blue")
plt.title("Salary vs Experience (Training Set)")
plt.xlabel("Years of Experience")
plt.ylabel("Salary")

plt.figure(2)
plt.scatter(x_test, y_test, color = "red")
plt.plot(x_train, pred, color = "blue")
plt.title("Salary vs Experience (Test Set)")
plt.xlabel("Years of Experience")
plt.ylabel("Salary")

plt.show()