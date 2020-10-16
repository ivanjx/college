# Aplikasi librarian.
# Oleh: Ivan Juan Kara.

from os import system, name

from models.book import book
from models.mahasiswa import mahasiswa
from models.borrow_data import borrow_data

from repositories.book_repository import book_repository
from repositories.mahasiswa_repository import mahasiswa_repository
from repositories.borrow_data_repository import borrow_data_repository

from services.book_service import book_service
from services.mahasiswa_service import mahasiswa_service
from services.borrow_service import borrow_service


def clear():
    if name == "nt":
        system("cls")
    else:
        system("clear")


def input_choice():
    s = input("Pilihan: ")
    
    try:
        return int(s)
    except:
        print("Input anda tidak valid, mohon input angka sesuai pilihan yang tersedia.")
        return input_choice()


def print_list_buku():
    books = book_repo.list_all()
    counter = 1

    for book in books:
        print("{}. Judul:\t\t{}".format(counter, book.nama))
        print("   ISBN:\t\t{}".format(book.isbn))
        print("   Pengarang:\t\t{}".format(book.pengarang))
        print("   Tahun Terbit:\t{}".format(book.tahun_terbit))
        print("   Ketersediaan:\t{}".format(book.qty))
        print()
        counter += 1

    return books


def list_buku():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Buku / List Buku")
    print_list_buku()

    print("Menu:")
    print("1. Kembali")
    choice = input_choice()
    
    if choice == 1:
        return False

    if not list_buku():
        return False


def tambah_buku():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Buku / Tambah Buku")
    
    try:
        b = book()
        b.isbn = input("ISBN: ")
        b.nama = input("Nama/Judul: ")
        b.pengarang = input("Nama Pengarang: ")
        b.tahun_terbit = int(input("Tahun Terbit: "))
        b.qty = int(input("Jumlah Tersedia: "))
        book_svc.create(b)
        print("Buku berhasil ditambah.")
    except Exception as e:
        print("Error:", e)

    print()
    print("Pilihan:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not tambah_buku():
        return False


def edit_buku():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Buku / Edit Buku")
    print("Daftar buku:")
    books = print_list_buku()

    try:
        choice = int(input("Nomor buku: "))
        
        if choice > len(books):
            raise Exception("nomor buku tidak valid")
        
        b = books[choice - 1]
        inama = input("Nama/Judul [{}]: ".format(b.nama))
        ipengarang = input("Nama Pengarang [{}]: ".format(b.pengarang))
        itahun_terbit = input("Tahun Terbit [{}]: ".format(b.tahun_terbit))
        iqty = input("Jumlah Tersedia [{}]: ".format(b.qty))
        
        if inama:
            b.nama = inama
        if ipengarang:
            b.pengarang = ipengarang
        if itahun_terbit:
            b.tahun_terbit = int(itahun_terbit)
        if iqty:
            b.qty = int(iqty)
        
        book_svc.update(b)
        print("Buku berhasil diupdate.")
    except Exception as e:
        print("Error:", e)

    print()
    print("Menu:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not edit_buku():
        return False


def hapus_buku():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Buku / Hapus Buku")
    print("Daftar buku:")
    books = print_list_buku()

    try:
        choice = int(input("Nomor buku: "))
        
        if choice > len(books):
            raise Exception("nomor buku tidak valid")
        
        b = books[choice - 1]
        choice = input("Apakah anda yakin ingin menghapus buku '{}' (y/N)? ".format(b.nama))

        if choice == "y":
            book_svc.delete(b.isbn)
            print("Buku berhasil dihapus.")
    except Exception as e:
        print("Error:", e)

    print()
    print("Menu:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not hapus_buku():
        return False


def book_menu():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Buku")
    print("Menu:")
    print("1. List buku")
    print("2. Tambah buku")
    print("3. Edit buku")
    print("4. Hapus buku")
    print("5. Kembali ke menu utama")
    choice = input_choice()

    if choice == 1:
        list_buku()
    elif choice == 2:
        tambah_buku()
    elif choice == 3:
        edit_buku()
    elif choice == 4:
        hapus_buku()
    elif choice == 5:
        return False

    if not book_menu():
        return False


def print_list_mhs():
    mahasiswa = mahasiswa_repo.list_all()
    counter = 1

    for m in mahasiswa:
        print("{}. Nama:\t{}".format(counter, m.nama))
        print("   NIM:\t\t{}".format(m.nim))
        print("   Jurusan:\t{}".format(m.jurusan))
        print()
        counter += 1

    return mahasiswa


def list_mhs():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Mahasiswa / List Mahasiswa")
    print_list_mhs()

    print("Menu:")
    print("1. Kembali")
    choice = input_choice()
    
    if choice == 1:
        return False

    if not list_mhs():
        return False


def tambah_mhs():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Mahasiswa / Tambah Mahasiswa")
    
    try:
        m = mahasiswa()
        m.nim = input("NIM: ")
        m.nama = input("Nama: ")
        m.jurusan = input("Jurusan: ")
        mahasiswa_svc.create(m)
        print("Mahasiswa berhasil ditambahkan.")
    except Exception as e:
        print("Error:", e)

    print()
    print("Pilihan:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not tambah_mhs():
        return False


def edit_mhs():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Mahasiswa / Edit Mahasiswa")
    print("Daftar mahasiswa:")
    mhs = print_list_mhs()

    try:
        choice = int(input("Nomor mahasiswa: "))
        
        if choice > len(mhs):
            raise Exception("nomor mahasiswa tidak valid")
        
        m = mhs[choice - 1]
        inama = input("Nama [{}]: ".format(m.nama))
        ijurusan = input("Jurusan [{}]: ".format(m.jurusan))
        
        if inama:
            m.nama = inama
        if ijurusan:
            m.jurusan = ijurusan
        
        mahasiswa_svc.update(m)
        print("Update data berhasil.")
    except Exception as e:
        print("Error:", e)

    print()
    print("Menu:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not edit_mhs():
        return False


def hapus_mhs():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Mahasiswa / Hapus Mahasiswa")
    print("Daftar mahasiswa:")
    mhs = print_list_mhs()

    try:
        choice = int(input("Nomor mahasiswa: "))
        
        if choice > len(mhs):
            raise Exception("nomor mahasiswa tidak valid")
        
        m = mhs[choice - 1]
        choice = input("Apakah anda yakin ingin menghapus mahasiswa '{}' (y/N)? ".format(m.nama))

        if choice == "y":
            mahasiswa_svc.delete(m.nim)
            print("Mahasiswa berhasil dihapus.")
    except Exception as e:
        print("Error:", e)

    print()
    print("Menu:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not hapus_mhs():
        return False


def mhs_menu():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Mahasiswa")
    print("Menu:")
    print("1. List mahasiswa")
    print("2. Tambah mahasiswa")
    print("3. Edit mahasiswa")
    print("4. Hapus mahasiswa")
    print("5. Kembali ke menu utama")
    choice = input_choice()

    if choice == 1:
        list_mhs()
    elif choice == 2:
        tambah_mhs()
    elif choice == 3:
        edit_mhs()
    elif choice == 4:
        hapus_mhs()
    elif choice == 5:
        return False

    if not mhs_menu():
        return False


def list_peminjaman():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Peminjaman / List Peminjam")
    data = borrow_data_repo.list_non_returned()
    counter = 1

    for d in data:
        book = book_repo.get(d.isbn)
        mhs = mahasiswa_repo.get(d.nim)
        print("{}. Buku:\t\t{} ({})".format(counter, book.nama, book.isbn))
        print("   Mahasiswa:\t\t{} ({})".format(mhs.nama, mhs.nim))
        print("   Tanggal Pinjam:\t{}".format(d.start_date))
        print()
        counter += 1

    print("Menu:")
    print("1. Kembali")
    choice = input_choice()

    if choice == 1:
        return False

    if not list_peminjaman():
        return False


def pinjam_buku():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Peminjaman / Pinjam Buku")

    try:
        # Prompting book.
        isbn = input("ISBN: ")
        book = book_repo.get(isbn)

        if not book:
            raise Exception("buku tidak ditemukan")

        if book.qty == 0:
            raise Exception("ketersediaan buku tidak valid")

        # Print book info.
        print("Judul: {}".format(book.nama))
        print("Pengarang: {}".format(book.pengarang))
        print("Tahun terbit: {}".format(book.tahun_terbit))
        print()

        # Prompting mahasiswa
        nim = input("NIM: ")
        mhs = mahasiswa_repo.get(nim)

        if not mhs:
            raise Exception("mahasiswa tidak ditemukan")

        # Print mhs info.
        print("Nama: {}".format(mhs.nama))
        print("Jurusan: {}".format(mhs.jurusan))

        print()
        choice = input("Apakah data sudah benar (y/N)? ")

        if choice == "y":
            # Saving.
            borrow_svc.borrow(nim, isbn)
            print("Buku berhasil dipinjam.")
    except Exception as e:
        print("Error", e)

    print()
    print("Menu:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not pinjam_buku():
        return False


def kembalikan_buku():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Peminjaman / Pengembalian Buku")

    try:
        # Prompting book.
        isbn = input("ISBN: ")
        book = book_repo.get(isbn)

        if not book:
            raise Exception("buku tidak ditemukan")

        # Print book info.
        print("Judul: {}".format(book.nama))
        print("Pengarang: {}".format(book.pengarang))
        print("Tahun terbit: {}".format(book.tahun_terbit))
        print()

        # Prompting mahasiswa
        nim = input("NIM: ")
        mhs = mahasiswa_repo.get(nim)

        if not mhs:
            raise Exception("mahasiswa tidak ditemukan")

        # Print mhs info.
        print("Nama: {}".format(mhs.nama))
        print("Jurusan: {}".format(mhs.jurusan))

        print()
        choice = input("Apakah data sudah benar (y/N)? ")

        if choice == "y":
            # Saving.
            borrow_svc.done_borrow(nim, isbn)
            print("Buku berhasil dikembalikan.")
    except Exception as e:
        print("Error", e)

    print()
    print("Menu:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not kembalikan_buku():
        return False


def cek_status_peminjaman():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Peminjaman / Cek Status Peminjaman")

    try:
            # Prompting book.
        isbn = input("ISBN: ")
        book = book_repo.get(isbn)

        if not book:
            raise Exception("buku tidak ditemukan")

        # Print book info.
        print("Judul: {}".format(book.nama))
        print("Pengarang: {}".format(book.pengarang))
        print("Tahun terbit: {}".format(book.tahun_terbit))
        print()

        # Prompting mahasiswa
        nim = input("NIM: ")
        mhs = mahasiswa_repo.get(nim)

        if not mhs:
            raise Exception("mahasiswa tidak ditemukan")

        # Print mhs info.
        print("Nama: {}".format(mhs.nama))
        print("Jurusan: {}".format(mhs.jurusan))

        # Getting borrow data.
        bd = borrow_data_repo.get(nim, isbn)

        if bd == None:
            raise Exception("data peminjaman tidak ditemukan")

        status = "SEDANG DIPINJAM"

        if bd.is_returned:
            status = "DIKEMBALIKAN"

        print()
        print("Status:", status)

        if bd.is_returned:
            print("Tanggal:", bd.return_date)
    except Exception as e:
        print("Error:", e)

    print()
    print("Menu:")
    print("1. Ulangi")
    print("2. Kembali")
    choice = input_choice()

    if choice == 2:
        return False

    if not cek_status_peminjaman():
        return False



def borrow_menu():
    clear()
    print("Aplikasi Perpustakaan ISTN / Manajemen Peminjaman")
    print("Menu:")
    print("1. List peminjaman")
    print("2. Pinjam buku")
    print("3. Kembalikan buku")
    print("4. Cek status peminjaman")
    print("5. Kembali ke menu utama")
    choice = input_choice()

    if choice == 1:
        list_peminjaman()
    elif choice == 2:
        pinjam_buku()
    elif choice == 3:
        kembalikan_buku()
    elif choice == 4:
        cek_status_peminjaman()
    else:
        return False

    if not borrow_menu():
        return False


def main_menu():
    clear()
    print("Aplikasi Perpustakaan ISTN")
    print("Menu:")
    print("1. Manage buku")
    print("2. Manage mahasiswa")
    print("3. Manage peminjaman")
    print("4. Exit")
    choice = input_choice()

    if choice == 1:
        book_menu()
    elif choice == 2:
        mhs_menu()
    elif choice == 3:
        borrow_menu()
    elif choice == 4:
        print("Terima kasih sudah memakai Aplikasi Perpustakaan ISTN.")
        print("Have a nice day! :)")
        return False

    main_menu()


# Initializing repositories.
book_repo = book_repository()
mahasiswa_repo = mahasiswa_repository()
borrow_data_repo = borrow_data_repository()

# Initializing services.
book_svc = book_service(book_repo, borrow_data_repo)
mahasiswa_svc = mahasiswa_service(mahasiswa_repo, borrow_data_repo)
borrow_svc = borrow_service(book_repo, mahasiswa_repo, borrow_data_repo)

# Main menu
main_menu()