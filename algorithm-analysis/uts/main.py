import os


def input_minuman():
    print("Daftar minuman:")
    print("1.  Orange Juice   (Rp 7.500)")
    print("2.  1. Coca Cola   (Rp 5.500)")
    print("    2. Fanta       (Rp 5.500)")
    print("    3. Sprite      (Rp 5.500)")
    print("    4. Teh Botol   (Rp 5.000)")
    print("3.  Aqua Gelas     (Rp 500)")
    
    minuman = {
        'nama': '',
        'harga': 0
    }
    
    kode = ''
    try:
        kode = input('Kode minuman: ')
    except Exception:
        pass

    if kode == '1':
        minuman['nama'] = 'Orange Juice'
        minuman['harga'] = 7500

    elif kode == '2':
        jenis = ''

        try:
            jenis = input('Jenis minuman: ')
        except Exception:
            pass

        if jenis == '1':
            minuman['nama'] = 'Coca Cola'
            minuman['harga'] = 5500
        elif jenis == '2':
            minuman['nama'] = 'Fanta'
            minuman['harga'] = 5500
        elif jenis == '3':
            minuman['nama'] = 'Sprite'
            minuman['harga'] = 5500
        elif jenis == '4':
            minuman['nama'] = 'Teh Botol'
            minuman['harga'] = 5000
    
    elif kode == '3':
        minuman['nama'] = 'Aqua Gelas'
        minuman['harga'] = 500

    return minuman


def input_makanan():
    print("Daftar makanan:")
    print("1.  Bakso          (Rp 19.000)")
    print("2.  Mie Ayam       (Rp 17.000)")
    print("3.  Mpe Mpe        (Rp 14.500)")

    makanan = {
        'nama': '',
        'harga': 0
    }
    kode = ''

    try:
        kode = input('Kode makanan: ')
    except Exception:
        pass

    if kode == '1':
        makanan['nama'] = 'Bakso'
        makanan['harga'] = 19000
    
    elif kode == '3':
        makanan['nama'] = 'Mie Ayam'
        makanan['harga'] = 17000

    elif kode == '4':
        makanan['nama'] = 'Mpe Mpe'
        makanan['harga'] = 14500

    return makanan


def main():
    while True:
        os.system('cls')
        total = 0

        # Input minuman.
        minum = input_minuman()
        
        if minum['nama'] == '':
            print('Tanpa minum.')
        else: 
            print('Minuman: {} ({})'.format(minum['nama'], minum['harga']))
            
            # Input jumlah.
            jumlah = int(input('Jumlah: '))
            total = total + (jumlah * minum['harga'])

        # Input makanan.
        print()
        makan = input_makanan()

        if makan['nama'] == '':
            print('Tanpa makan.')
        else:
            print('Makanan: {} ({})'.format(makan['nama'], makan['harga']))

            # Input jumlah.
            jumlah = int(input('Jumlah: '))
            total = total + (jumlah * makan['harga'])

        # Diskon.
        diskonp = 0

        if total > 500000:
            diskonp = 10
        elif total > 100000:
            diskonp = 5

        # Total.
        print()
        print('Subtotal: {}'.format(total))
        total = total - (total * diskonp // 100)
        print('Diskon: {}%'.format(diskonp))
        print('Total: {}'.format(total))

        print()
        input('Enter untuk mengulang.')


main()