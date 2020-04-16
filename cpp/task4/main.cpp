#include <iostream>

typedef struct
{
    std::string nama;
    int umur;
    std::string cat;
} Person;

Person _people[40];

void swapPerson(Person *a, Person *b)
{
    Person c = *a;
    *a = *b;
    *b = c;
}

void sort(int nMhs)
{
    for (int i = 0; i < nMhs; ++i)
    {
        for (int j = i + 1; j < nMhs; ++j)
        {
            if (_people[i].umur > _people[j].umur)
            {
                swapPerson(&_people[i], &_people[j]);
            }
        }
    }
}

int main()
{
    int n;
    std::cout << "Masukkan jumlah data: ";
    std::cin >> n;

    if (n > 40)
    {
        std::cout 
            << "Data terlalu banyak..." 
            << std::endl;
        return 1;
    }

    // Input.
    for (int i = 0; i < n; ++i)
    {
        std::cout 
            << "Data ke-" << i + 1 << ":" 
            << std::endl;
        
        std::cout << "Nama: ";
        std::cin >> _people[i].nama;

        std::cout << "Umur: ";
        std::cin >> _people[i].umur;

        if (_people[i].umur < 5)
        {
            _people[i].cat = "Balita";
        }
        else if (_people[i].umur < 12)
        {
            _people[i].cat = "Anak";
        }
        else if (_people[i].umur < 18)
        {
            _people[i].cat = "Remaja";
        }
        else
        {
            _people[i].cat = "Dewasa";
        }
        

        std::cout << std::endl;
    }

    // Sort.
    sort(n);

    // Print.
    std::cout
        << "Urutan berdasarkan umur:"
        << std::endl;

    for (int i = 0; i < n; ++i)
    {
        std::cout 
            << "Data ke-" << i + 1 << ":"
            << std::endl;

        std::cout
            << "Nama: " << _people[i].nama
            << std::endl
            << "Umur: " << _people[i].umur
            << std::endl
            << "Kategori: " << _people[i].cat
            << std::endl
            << std::endl;
    }
}