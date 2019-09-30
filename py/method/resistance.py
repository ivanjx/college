def seri(r1, r2, r3):
  return r1 + r2 + r3


def paralel(r1, r2, r3):
  return 1 / r1 + 1 / r2 + 1 / r3


# Input.
r1 = float(input('R1: '))
r2 = float(input('R2: '))
r3 = float(input('R3: '))

print('Seri: ' + str(seri(r1, r2, r3)))
print('Paralel: ' + str(paralel(r1, r2, r3)))