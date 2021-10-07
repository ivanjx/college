import matplotlib.pyplot as plt
import pandas as pd
from sklearn.linear_model import LinearRegression

dataset = pd.read_csv("salary_data.csv")
x = dataset.iloc[:, :-1].values
y = dataset.iloc[:, 1].values

regressor = LinearRegression()
regressor.fit(x, y)

print("Berapa tahun pengalaman anda bekerja?")
tahun = float(input(">>> "))
y_pred = regressor.predict([[tahun]])
print("Perkiraan gaji anda adalah:", y_pred[0])