import json


def calculate(cent):
  # Note:
  # 1 quarter = 25 cents
  # 1 dime = 10 cents
  # 1 nickle = 5 cents
  # 1 penny = 1 cent
  result = {}

  # Calculating quarter.
  result['quarter'] = cent // 25
  cent -= result['quarter'] * 25

  # Calculating dime.
  result['dime'] = cent // 10
  cent -= result['dime'] * 10

  # Calculating nickle.
  result['nickle'] = cent // 5
  cent -= result['nickle'] * 5

  # Pennies.
  result['penny'] = cent

  # Done.
  return result


def main():
  # Input cents.
  cent = int(input('Cents: '))
  
  # Calculate.
  result = calculate(cent)

  # Done.
  print(json.dumps(result))


if __name__ == "__main__":
  main()