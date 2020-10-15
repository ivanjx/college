class book:
    def __init__(self):
        self.isbn = ""
        self.nama = ""
        self.pengarang = ""
        self.tahun_terbit = 0
        self.qty = 0

    
    def is_available(self):
        return self.qty > 0