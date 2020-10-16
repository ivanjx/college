from datetime import datetime

class borrow_data:
    def __init__(self):
        self.nim = ""
        self.isbn = ""
        self.start_date = datetime.now()
        self.is_returned = False
        self.return_date = datetime.now()