import math


def validate(l1, l2, l3):
  if (
    l1 < l2 + l3 and
    l2 < l1 + l3 and
    l3 < l1 + l2
    ):
    return

  raise Exception('Segitiga tidak valid')


def get_half_perimeter(l1, l2, l3):
  return (l1 + l2 + l3) / 2


def get_area(s, l1, l2, l3):
  x = s * (s - l1) * (s - l2) * (s - l3)
  return math.sqrt(x)


def main():
  # Input Ls.
  l1 = float(input('L1-> '))
  l2 = float(input('L2-> '))
  l3 = float(input('L3-> '))

  # Validating.
  validate(l1, l2, l3)

  # Calculating half perimeter.
  s = get_half_perimeter(l1, l2, l3)

  # Getting area.
  area = get_area(s, l1, l2, l3)

  # Done.
  print("Area segitiga: " + str(area))


if __name__ == "__main__":
  main()