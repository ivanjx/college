import math


def simple_add(n):
  if n == 0:
    return n

  return simple_add(n - 1) + n


def factorial(n):
  if n == 1:
    return n

  return factorial(n - 1) * n


def power(a, n):
  if n == 0:
    return math.pow(a, n) # 1

  return power(a, n - 1) * math.pow(a, n)


def fib(n):
  if n == 1 or n == 0:
    return n

  return fib(n - 1) + fib(n - 2)


def gcd(a, b):
  if b == 0:
    return a

  return gcd(b, a % b)


def simple_add_tail(a, result):
  if a == 0:
    return result

  return simple_add_tail(a - 1, result + a)


def factorial_tail(n, result):
  if n == 1:
    return result

  return factorial_tail(n - 1, result * n)


def power_tail(a, n, result):
  if n == 0:
    return result

  return power_tail(a, n - 1, math.pow(a, n) * result)


def fib_tail(n, result):
  if n == 1 or n == 0:
    return result

  return fib_tail(n - 1, fib_tail(n - 1, result) + fib_tail(n - 2, result))


def main():
  print(power_tail(2, 2, 1))


if __name__ == "__main__":
  main()