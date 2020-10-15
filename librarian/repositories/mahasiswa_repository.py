class mahasiswa_repository:
    def __init__(self):
        self.mhs = []

    def create(self, mahasiswa):
        self.mhs.append(mahasiswa)

    def get(self, nim):
        for m in self.mhs:
            if m.nim == nim:
                return m
        
        return None

    def update(self, data):
        m = self.get(data.nim)
        m.nama = data.nama
        m.jurusan = data.jurusan

    def delete(self, nim):
        self.mhs = [x for x in self.mhs if x.nim != nim]