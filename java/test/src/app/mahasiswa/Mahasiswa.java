package app.mahasiswa;

public class Mahasiswa {
    // Public variable.
    public String NIM;
    public String Nama;
    public int Angkatan;
    public String UkuranAlmamater;

    // Inisialisasi / konstructor.
    public Mahasiswa(String nim, String nama, int angkatan, String ukuranAlmamater) {
        NIM = nim;
        Nama = nama;
        Angkatan = angkatan;
        UkuranAlmamater = ukuranAlmamater;
    }

    // Overloading constructor.
    public Mahasiswa(String nim, String nama) {
        NIM = nim;
        Nama = nama;
        Angkatan = 2023;
        UkuranAlmamater = "L";
    }

    public Mahasiswa() {
        // Nothing.
    }

    // Public method.
    // Print.
    public void print() {
        System.out.println("NIM: " + NIM);
        System.out.println("Nama: " + Nama);
        System.out.println("Angkatan: " + Angkatan);
        System.out.println("Ukuran almamater: " + UkuranAlmamater);
    }
}