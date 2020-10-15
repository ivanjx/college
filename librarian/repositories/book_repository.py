class book_repository:
    def __init__(self):
        self.books = []

    def create(self, book):
        self.books.append(book)

    def get(self, book_isbn):
        for book in self.books:
            if book.isbn == book_isbn:
                return book
        
        return None

    def delete(self, book_isbn):
        self.books = [x for x in self.books if x.isbn != book_isbn]

    def update(self, data):
        book = self.get(data.isbn)
        book.name = data.name
        book.pengarang = data.pengarang
        book.tahun_terbit = data.tahun_terbit