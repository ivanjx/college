#include <iostream>

typedef struct
{
    char nim[10];
    char nama[100];
    char tanggal_lahir[11];
    char jenis_kelamin;
    int angkatan;
    char asal_kota[30];
    float ipk;
    char ukuran_almamater[3];
} Mahasisiwa;

int main()
{
    Mahasisiwa data[10];

    std::cout 
        << "===========================" << std::endl
        << "PROGRAM STRUCT OF ARRAY" << std::endl
        << "===========================" << std::endl;

    std::cout << "Masukkan jumlah data: ";
    int n;
    std::cin >> n;

    if (n > 10)
    {
        std::cout << "Data terlalu banyak." << std::endl;
        return 1;
    }

    for (int i = 0; i < n; ++i)
    {
        std::cout 
            << std::endl
            << "Data ke-" << i + 1 << std::endl;
        
        std::cout << "Nama: ";
        std::cin >> data[i].nama;

        std::cout << "NIM: ";
        std::cin >> data[i].nim;

        std::cout << "Tanggal lahir (ddmmyyyy): ";
        std::cin >> data[i].tanggal_lahir;

        std::cout << "Jenis kelamin (L/P): ";
        std::cin >> data[i].jenis_kelamin;

        std::cout << "Angkatan: ";
        std::cin >> data[i].angkatan;

        std::cout << "Asal kota: ";
        std::cin >> data[i].asal_kota;

        std::cout << "IPK: ";
        std::cin >> data[i].ipk;

        std::cout << "Ukuran almamater (S/M/L/XL): ";
        std::cin >> data[i].ukuran_almamater;

        std::cout << "--------------------" << std::endl;
    }

    std::cout 
        << std::endl
        << "Masukkan data yang ingin ditampilkan: ";
    
    int find;
    std::cin >> find;
    Mahasisiwa mhs = data[find-1];

    std::cout 
        << "Nama: " << mhs.nama << std::endl
        << "NIM: " << mhs.nim << std::endl
        << "Tanggal lahir: " << mhs.tanggal_lahir << std::endl
        << "Jenis kelamin: " << mhs.jenis_kelamin << std::endl
        << "Angkatan: " << mhs.angkatan << std::endl
        << "Asal kota: " << mhs.asal_kota << std::endl
        << "IPK: " << mhs.ipk << std::endl
        << "Ukuran almamater: " << mhs.ukuran_almamater << std::endl;

    std::getchar();
}