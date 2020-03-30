#include <iostream>

int main()
{
    std::cout << "Nilai angka: ";
    float nilai;
    std::cin >> nilai;

    std::cout << "Nilai anda ";

    if (nilai >= 90)
    {
        std::cout << "Sangat baik";
    }
    else if (nilai >= 80)
    {
        std::cout << "Baik";
    }
    else if (nilai >= 70)
    {
        std::cout << "Cukup";
    }
    else if (nilai >= 60) 
    {
        std::cout << "Kurang";
    }
    else
    {
        std::cout << "Buruk";
    }

    std::cout << std::endl;
}