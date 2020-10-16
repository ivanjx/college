class borrow_service:
    def __init__(self, book_repo, mhs_repo, borrow_repo):
        self.book_repo = book_repo
        self.mhs_repo = mhs_repo
        self.borrow_repo = borrow_repo

    
    def borrow(self, nim, isbn):
        # Validating.
        pass


    def done_borrow(self, nim, isbn):
        # Validating.
        pass


    def list_borrows(self, date):
        pass