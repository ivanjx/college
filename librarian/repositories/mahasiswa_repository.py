import os.path
import json
from models.mahasiswa import mahasiswa

class mahasiswa_repository:
    NAME = "db/mhs.json"


    def load(self):
        self.mhs = []

        # Check if file exists.
        if not os.path.isfile(mahasiswa_repository.NAME):
            # Empty collection.
            return

        # Reading file.
        with open(mahasiswa_repository.NAME, "r") as infs:
            raw = json.load(infs)

            if not raw["data"] or not isinstance(raw["data"], list):
                # Invalid file content.
                infs.close()
                os.unlink(mahasiswa_repository.NAME)
            else:
                # Deserializing.
                for r in raw["data"]:
                    m = mahasiswa()
                    m.nim = r["nim"]
                    m.nama = r["nama"]
                    m.jurusan = r["jurusan"]
                    self.mhs.append(m)


    def save(self):
        if not os.path.isdir("db"): os.mkdir("db")

        with open(mahasiswa_repository.NAME, "w+") as outfs:
            # Serializing.
            raw = {}
            raw["data"] = []
            
            for m in self.mhs:
                r = {}
                r["nim"] = m.nim
                r["nama"] = m.nama
                r["jurusan"] = m.jurusan
                raw["data"].append(r)

            # Saving.
            json.dump(raw, outfs)


    def __init__(self):
        self.load()


    def create(self, mahasiswa):
        self.mhs.append(mahasiswa)
        self.save()


    def get(self, nim):
        for m in self.mhs:
            if m.nim == nim:
                return m
        
        return None


    def update(self, data):
        m = self.get(data.nim)
        m.nama = data.nama
        m.jurusan = data.jurusan
        self.save()


    def delete(self, nim):
        self.mhs = [x for x in self.mhs if x.nim != nim]
        self.save()