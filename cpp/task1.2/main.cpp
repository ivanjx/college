#include <iostream>

int main() 
{
    const std::string test = "Institut Sains Teknologi Nasional";
    const std::string inames[] = 
    {
        "pertama",
        "kedua",
        "ketiga",
        "keempat"
        //etc
    };

    int iname = 0;
    std::cout << "Iterasi " << inames[iname] << ": ";

    for (int i = 0; i < test.length(); ++i) {
        if (test[i] == ' ')
        {
            ++iname;
            std::cout << std::endl;
            std::cout << "Iterasi " << inames[iname] << ": ";
            continue;
        }

        std::cout << test[i];
    }
}