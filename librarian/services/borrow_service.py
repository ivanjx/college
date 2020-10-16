from datetime import datetime
from models.borrow_data import borrow_data

class borrow_service:
    def __init__(self, book_repo, mhs_repo, borrow_repo):
        self.book_repo = book_repo
        self.mhs_repo = mhs_repo
        self.borrow_repo = borrow_repo


    def validate_isbn(self, isbn):
        book = self.book_repo.get(isbn)

        if not book:
            raise Exception("isbn tidak terdaftar")

        if book.qty == 0:
            raise Exception("buku sudah tidak tersedia")


    def validate_nim(self, nim):
        mhs = self.mhs_repo.get(nim)

        if not mhs:
            raise Exception("nim tidak terdaftar")


    def validate_borrow(self, nim, isbn):
        dupe = self.borrow_repo

        if dupe:
            raise Exception("nim dan isbn yang sama sudah meminjam")

    
    def borrow(self, nim, isbn):
        # Validating.
        self.validate_nim(nim)
        self.validate_isbn(isbn)

        # Subtracting qty.
        self.book_repo.sub_qty_1(isbn)

        # Creating.
        data = borrow_data()
        data.nim = nim
        data.isbn = isbn 
        self.borrow_repo.create(data)


    def done_borrow(self, nim, isbn):
        # Validating.
        if not nim:
            raise Exception("nim kosong")

        if not isbn:
            raise Exception("isbn kosong")

        data = self.borrow_repo.get(nim, isbn)

        if not data:
            raise Exception("data peminjaman tidak ditemukan")

        # Setting return date to now.
        self.borrow_repo.set_return_date(datetime.now())

        # Adding qty.
        self.book_repo.add_qty_1(isbn)