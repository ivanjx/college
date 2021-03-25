class mahasiswa_service:
    def __init__(self, mahasiswa_repo, borrow_data_repo):
        self.mahasiswa_repo = mahasiswa_repo
        self.borrow_data_repo = borrow_data_repo

    def validate(self, data, isupdate = False):
        if not data:
            raise Exception("data is null")

        if not data.nim:
            raise Exception("nim kosong")

        if not data.nama:
            raise Exception("nama kosong")

        if not data.jurusan:
            raise Exception("jurusan kosong")

        if isupdate:
            return

        dupe = self.mahasiswa_repo.get(data.nim)

        if dupe:
            raise Exception("nim sudah terdaftar")


    def create(self, data):
        # Validating.
        self.validate(data)
        
        # Adding.
        self.mahasiswa_repo.create(data)


    def update(self, data):
        # Validating.
        self.validate(data, True)

        # Updating.
        self.mahasiswa_repo.update(data)


    def delete(self, nim):
        if not nim:
            raise Exception("nim kosong")

        # Deleting from borrow data.
        self.borrow_data_repo.delete_by_nim(nim)

        # Deleting from mhs repo.
        self.mahasiswa_repo.delete(nim)