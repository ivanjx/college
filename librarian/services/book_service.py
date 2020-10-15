class book_service:
    def __init__(self, book_repo, borrow_data_repo):
        self.book_repo = book_repo
        self.borrow_data_repo = borrow_data_repo


    def validate(self, data):
        if not data:
            raise Exception("data is null")

        if not data.isbn:
            raise Exception("isbn kosong")

        if not data.nama:
            raise Exception("nama kosong")

        if not data.pengarang:
            raise Exception("pengarang kosong")

        if not data.tahun_terbit:
            raise Exception("tahun terbit kosong")

        if data.qty < 0:
            raise Exception("jumlah buku invalid")

        dupe = self.book_repo.get(data.isbn)

        if dupe:
            raise Exception("isbn sudah terdaftar")

    
    def create(self, data):
        # Validating.
        self.validate(data)

        # Adding.
        self.book_repo.create(data)


    def update(self, data):
        # Validating.
        self.validate(data)

        # Updating.
        self.book_repo.update(data)


    def delete(self, isbn):
        # Validating.
        if not isbn:
            raise Exception("isbn kosong")

        # Deleting from borrow repo.
        self.borrow_data_repo.delete_by_isbn(isbn)

        # Deleting from book repo.
        self.book_repo.delete(isbn)