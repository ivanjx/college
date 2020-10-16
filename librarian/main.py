# Aplikasi librarian.
# Oleh: Ivan Juan Kara.

from models.book import book
from models.mahasiswa import mahasiswa
from models.borrow_data import borrow_data

from repositories.book_repository import book_repository
from repositories.mahasiswa_repository import mahasiswa_repository
from repositories.borrow_data_repository import borrow_data_repository

from services.book_service import book_service
from services.mahasiswa_service import mahasiswa_service
from services.borrow_service import borrow_service


def create_books(book_svc):
    b = book()
    b.isbn = "123456789"
    b.nama = "buku 1"
    b.pengarang = "ivan"
    b.tahun_terbit = 2010
    b.qty = 1
    book_svc.create(b)

    b = book()
    b.isbn = "123123123"
    b.nama = "buku 2"
    b.pengarang = "ivan"
    b.tahun_terbit = 2011
    b.qty = 3
    book_svc.create(b)


def main():
    # Initializing repositories.
    book_repo = book_repository()
    mahasiswa_repo = mahasiswa_repository()
    borrow_data_repo = borrow_data_repository()

    # Initializing services.
    book_svc = book_service(book_repo, borrow_data_repo)
    mahasiswa_svc = mahasiswa_service(mahasiswa_repo, borrow_data_repo)
    borrow_svc = borrow_service(book_repo, mahasiswa_repo, borrow_data_repo)

    # Creating books.
    create_books(book_svc)
    print()


main()