import json


def calculate(
  quarter_stock,
  dime_stock,
  nickle_stock,
  penny_stock,
  cent):
  # Note:
  # 1 quarter = 25 cents
  # 1 dime = 10 cents
  # 1 nickle = 5 cents
  # 1 penny = 1 cent
  result = {}

  # Calculating quarter.
  quarter_count = cent // 25
  quarter_stock_rem = max(quarter_stock - quarter_count, 0) # Cant be negative.
  result['quarter'] = (quarter_stock - quarter_stock_rem)
  cent -= result['quarter'] * 25

  # Calculating dime.
  dime_count = cent // 10
  dime_stock_rem = max(dime_stock - dime_count, 0) # Cant be negative.
  result['dime'] = (dime_stock - dime_stock_rem)
  cent -= result['dime'] * 10

  # Calculating nickle.
  nickle_count = cent // 5
  nickle_stock_rem = max(nickle_stock - nickle_count, 0) # Cant be negative.
  result['nickle'] = (nickle_stock - nickle_stock_rem)
  cent -= result['nickle'] * 5

  # Pennies.
  penny_stock_rem = max(penny_stock - cent, 0) # Cant be negative.
  result['penny'] = (penny_stock - penny_stock_rem)
  cent -= result['penny']

  # Check.
  if cent > 0:
    raise Exception('Insufficient coin stock')

  # Done.
  return result


def main():
  # Input coin stock.
  quarter_stock = int(input('Quarter: '))
  dime_stock = int(input('Dime: '))
  nickle_stock = int(input('Nickle: '))
  penny_stock = int(input('Penny: '))

  # Input cents.
  cent = int(input('Cents: '))
  
  # Calculate.
  result = calculate(
    quarter_stock,
    dime_stock,
    nickle_stock,
    penny_stock,
    cent
  )

  # Done.
  print(json.dumps(result))


if __name__ == "__main__":
  main()