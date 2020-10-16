import os.path
import json
from models.book import book

class book_repository:
    NAME = "db/books.json"

    def load(self):
        self.books = []

        # Check if file exists.
        if not os.path.isfile(book_repository.NAME):
            # Empty collection.
            return

        # Reading file.
        with open(book_repository.NAME, "r") as infs:
            raw = json.load(infs)

            if not raw["data"] or not isinstance(raw["data"], list):
                # Invalid file content.
                infs.close()
                os.unlink(book_repository.NAME)
            else:
                # Deserializing.
                for r in raw["data"]:
                    b = book()
                    b.isbn = r["isbn"]
                    b.nama = r["nama"]
                    b.pengarang = r["pengarang"]
                    b.tahun_terbit = r["tahun_terbit"]
                    self.books.append(b)


    def save(self):
        if not os.path.isdir("db"): os.mkdir("db")

        with open(book_repository.NAME, "w+") as outfs:
            # Serializing.
            raw = {}
            raw["data"] = []
            
            for b in self.books:
                r = {}
                r["isbn"] = b.isbn
                r["nama"] = b.nama
                r["pengarang"] = b.pengarang
                r["tahun_terbit"] = b.tahun_terbit
                raw["data"].append(r)

            # Saving.
            json.dump(raw, outfs)


    def __init__(self):
        self.load()


    def list_all(self):
        return self.books


    def create(self, book):
        self.books.append(book)
        self.save()


    def get(self, book_isbn):
        for book in self.books:
            if book.isbn == book_isbn:
                return book
        
        return None

    
    def add_qty_1(self, isbn):
        book = self.get(isbn)
        book.qty += 1
        self.save()


    def sub_qty_1(self, isbn):
        book = self.get(isbn)
        book.qty -= 1
        self.save()


    def delete(self, book_isbn):
        self.books = [x for x in self.books if x.isbn != book_isbn]
        self.save()


    def update(self, data):
        book = self.get(data.isbn)
        book.nama = data.nama
        book.pengarang = data.pengarang
        book.tahun_terbit = data.tahun_terbit
        book.qty = data.qty
        self.save()