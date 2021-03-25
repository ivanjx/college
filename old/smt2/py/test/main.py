# Deklarasi matriks
matriks = []

# masukkan nilai
# cara 1
#matriks.append([1, 2, 3])
#matriks.append([4, 5, 6])
#matriks.append([7, 8, 9])

# cara 2
matriks.append([])
matriks[0].append(1)
matriks[0].append(2)
matriks[0].append(3)

matriks.append([])
matriks[1].append(4)
matriks[1].append(5)
matriks[1].append(6)

matriks.append([])
matriks[2].append(7)
matriks[2].append(8)
matriks[2].append(9)

# print.
for hval in matriks:
  for vval in hval:
    print(vval, end=" ")

  # baris baru.
  print()