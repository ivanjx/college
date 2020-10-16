import os.path
import json
from datetime import datetime
from models.borrow_data import borrow_data


class borrow_data_repository:
    NAME = "db/borrow.json"


    def load(self):
        self.borrow_data_list = []

        # Check if file exists.
        if not os.path.isfile(borrow_data_repository.NAME):
            return

        # Reading file.
        with open(borrow_data_repository.NAME, "r") as infs:
            raw = json.load(infs)

            if not raw["data"] or not isinstance(raw["data"], list):
                # Invalid file content.
                infs.close()
                os.unlink(borrow_data_repository.NAME)
            else:
                # Deserializing.
                for r in raw["data"]:
                    b = borrow_data()
                    b.nim = r["nim"]
                    b.isbn = r["isbn"]
                    b.start_date = datetime.fromtimestamp(r["start_date"])
                    b.is_returned = r["is_returned"]
                    b.return_date = datetime.fromtimestamp(r["return_date"])
                    self.borrow_data_list.append(b)


    def save(self):
        if not os.path.isdir("db"): os.mkdir("db")

        with open(borrow_data_repository.NAME, "w+") as outfs:
            # Serializing.
            raw = {}
            raw["data"] = []

            for b in self.borrow_data_list:
                r = {}
                r["nim"] = b.nim
                r["isbn"] = b.isbn
                r["start_date"] = b.start_date.timestamp()
                r["is_returned"] = b.is_returned 
                r["return_date"] = b.return_date.timestamp()
                raw["data"].append(r)

            # Saving.
            json.dump(raw, outfs)


    def __init__(self):
        self.load()


    def create(self, borrow_data):
        self.borrow_data_list.append(borrow_data)
        self.save()


    def get(self, nim, isbn):
        for data in self.borrow_data_list:
            if data.nim == nim and data.isbn == isbn:
                return data

        return None


    def list_by_mhs_nim(self, nim):
        return [x for x in self.borrow_data_list if x.nim == nim]


    def list_by_book_isbn(self, isbn):
        return [x for x in self.borrow_data_list if x.isbn == isbn]


    def list_non_returned(self):
        return [
            x for x in self.borrow_data_list
            if not x.is_returned
        ]


    def set_return_date(self, nim, isbn, date):
        data = self.get(nim, isbn)
        data.is_returned = True
        data.return_date = date
        self.save()


    def delete_by_nim(self, nim):
        self.borrow_data_list = [
            x for x in self.borrow_data_list
            if x.nim != nim
        ]
        self.save()


    def delete_by_isbn(self, isbn):
        self.borrow_data_list = [
            x for x in self.borrow_data_list
            if x.isbn != isbn
        ]
        self.save()