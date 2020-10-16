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
        pass
    elif choice == 2:
        pass
    elif choice == 3:
        pass
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