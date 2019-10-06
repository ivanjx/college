# Struktur WHILE.
total = 0
jumlah = 0

while True:
  # Baca nilai angka.
  angka = int(input('Angka: '))

  # Cek.
  if angka == 0:
    # Kita mendapat nilai 0 disini.
    # Keluar dari blok loop.
    break

  else:
    # Jika selain dari 0.
    # Naikkan nilai jumlah.
    jumlah += 1

    # Tambah nilai total.
    total += angka

# Ini sudah bukan berada di dalam blok while.
print('Sudah ada diluar blok while')
rata2 = total / jumlah
print('Rata-rata: ', rata2)


# APA ITU BREAK?
# Break digunakan ketika kita ingin keluar secara paksa dari suatu blok LOOP, (for maupun while)