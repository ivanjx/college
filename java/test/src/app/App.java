package app;

import java.util.Scanner;

import app.mahasiswa.Mahasiswa;

public class App {
    // Data mahasiswa.
    // - NIM: string/integer
    // - Nama: string
    // - Angkatan: integer
    // - dll

    public static void main(String[] args) {
        Mahasiswa mhs = new Mahasiswa();
        mhs.Nama = "Ivan";
        mhs.UkuranAlmamater = "L";
        mhs.print();
    }
}