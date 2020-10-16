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
        input_choice()


def print_list_buku():
    books = book_repo.list_all()
    counter = 1

    for book in books:
        print("{}. {}. Tahun {}. Oleh {}. Tersedia {}".format(counter, book.nama, book.tahun_terbit, book.pengarang, book.qty))
        counter += 1

    return books


def list_buku():
    clear()
    print("Aplikasi Perpustakaan ISTN - Manajemen Buku - List Buku")
    print_list_buku()

    print()
    print("Menu:")
    print("1. Kembali")
    choice = input_choice()
    
    if choice == 1:
        return False

    if not list_buku():
        return False


def tambah_buku():
    clear()
    print("Aplikasi Perpustakaan ISTN - Manajemen Buku - Tambah Buku")
    
    try:
        b = book()
        b.isbn = input("ISBN: ")
        b.nama = input("Nama/Judul: ")
        b.pengarang = input("Nama Pengarang: ")
        b.tahun_terbit = int(input("Tahun Terbit: "))
        b.qty = int(input("Jumlah Tersedia: "))
        book_svc.create(b)
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
    print("Aplikasi Perpustakaan ISTN - Manajemen Buku - Edit Buku")
    print("Daftar buku:")
    books = print_list_buku()

    try:
        print()
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


def book_menu():
    clear()
    print("Aplikasi Perpustakaan ISTN - Manajemen Buku")
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
        pass
    elif choice == 5:
        return False

    if not book_menu():
        return False


def mhs_menu():
    clear()
    print("Aplikasi Perpustakaan ISTN - Manajemen Mahasiswa")
    print("Menu:")
    print("1. List mahasiswa")
    print("2. Tambah mahasiswa")
    print("3. Edit mahasiswa")
    print("4. Hapus mahasiswa")
    print("5. Kembali ke menu utama")
    choice = input_choice()

    if choice == 1:
        pass
    elif choice == 2:
        pass
    elif choice == 3:
        pass
    elif choice == 4:
        pass
    elif choice == 5:
        return False

    if not mhs_menu():
        return False


def borrow_menu():
    clear()
    print("Aplikasi Perpustakaan ISTN - Manajemen Peminjaman")
    print("Menu:")
    print("1. List peminjam")
    print("2. List buku yang dipinjam")
    print("3. Pinjam buku")
    print("4. Kembalikan buku")
    print("5. Kembali ke menu utama")
    choice = input_choice()

    if choice == 1:
        pass
    elif choice == 2:
        pass
    elif choice == 3:
        pass
    elif choice == 4:
        pass
    elif choice == 5:
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