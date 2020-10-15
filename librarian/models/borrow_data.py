from datetime import datetime

class borrow_data:
    def __init__(self):
        self.nim = ""
        self.isbn = ""
        self.start_date = datetime.now()
        self.return_date = datetime.now()

    def is_borrowing(self):
        return self.start_date > datetime.now()

    def is_returned(self):
        return self.return_date != None