from datetime import datetime
from models.borrow_data import borrow_data

class borrow_service:
    MAX_BORROW_DAYS = 7
    DEBT_PER_DAY = 3000

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

    
    def borrow(self, nim, isbn):
        # Validating.
        self.validate_nim(nim)
        self.validate_isbn(isbn)

        dupe = self.borrow_repo.get(nim, isbn)

        if dupe and not dupe.is_returned:
            raise Exception("nim dan isbn yang sama sudah terdata")

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

        if data.is_returned:
            raise Exception("data peminjaman invalid")

        # Setting return date to now.
        self.borrow_repo.set_return_date(nim, isbn, datetime.now())

        # Adding qty.
        self.book_repo.add_qty_1(isbn)


    def calculate_debt(self, nim, isbn):
        # Getting borrow data.
        data = self.borrow_repo.get(nim, isbn)

        if not data:
            raise Exception("data peminjaman tidak ditemukan")

        # Calculating debt.
        borrow_days = data.get_borrow_days()
        debt = 0

        if borrow_days > borrow_service.MAX_BORROW_DAYS:
            debt = borrow_service.DEBT_PER_DAY * data.get_borrow_days()
        # else no debt.

        return debt