#include <iostream>

int main()
{
    int A, B, C;
    A = 11;
    B = A / 2;
    C = A + B / 2;
    std::cout << C << std::endl;
    A = B;
    B = A * 2;
    C = A + B / 2;
    std::cout << C << std::endl;
    A = B;
    B = A * 2;
    C = A + B / 2;
    std::cout << C << std::endl;
    
    return 0;
}