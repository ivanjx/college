from datetime import datetime

class borrow_data:
    def __init__(self):
        self.nim = ""
        self.isbn = ""
        self.start_date = datetime.now()
        self.is_returned = False
        self.return_date = datetime.now()

    def get_borrow_days(self):
        if self.is_returned:
            return self.return_date - self.start_date
        else:
            return (datetime.now() - self.start_date).days