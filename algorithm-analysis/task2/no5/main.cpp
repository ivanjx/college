#include <iostream>

int main()
{
    int a, b, c;
    std::cin >> a;
    std::cin >> b;
    std::cin >> c;

    if (a == b || a == c || b == c)
    {
        std::cout << "SAMA KAKI" << std::endl;
    }

    return 0;
}