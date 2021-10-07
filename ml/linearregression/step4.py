import pandas as pd
import numpy as np
from sklearn.linear_model import LinearRegression
from sklearn.model_selection import train_test_split
from sklearn.metrics import r2_score, mean_absolute_error, mean_squared_error

dataset = pd.read_csv("salary_data.csv")
x = dataset.iloc[:, :-1].values
y = dataset.iloc[:, 1].values

lr = LinearRegression()
lr.fit(x, y)

SALARY_PRED = "Salary_Pred"
SALARY = "Salary"
SST = "SST"
SSR = "SSR"

dataset[SALARY_PRED] = lr.predict(x)

dataset[SST] = np.square(dataset[SALARY] - dataset[SALARY].mean())
dataset[SSR] = np.square(dataset[SALARY_PRED] - dataset[SALARY].mean())
print("Sum of SSR:", dataset[SSR].sum())
print("Sum of SST:", dataset[SST].sum())
print("R squared using manual calculation:", dataset[SST].sum() / dataset[SSR].sum())

print("R squared using built-in function:", lr.score(x, y))
mae = mean_absolute_error(y, dataset[SALARY_PRED])
print("Mean absolute error:", mae)
print("Root mean squared error:", np.sqrt(mae))

print("Correlation matrix:")
print(dataset.corr())