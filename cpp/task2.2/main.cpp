#include <iostream>

void printBintang(int n)
{
    for(int i = 0; i < n; ++i)
    {
        std::cout << "*";
    }

    std::cout << std::endl;
}

int main()
{
    int inc = -1;
    int end = 1;

    for (int i = 5; ; i += inc)
    {
        printBintang(i);

        if (i == end)
        {
            if (inc == 1)
            {
                break;
            }

            i = 0;
            inc = 1;
            end = 5;
        }
    }
}