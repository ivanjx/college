#include <iostream>

int main() 
{
    const int arr[][4] =
    { 
        {1, 2, 3, 4},
        {5, 6, 7, 8},
        {9, 10, 11, 12},
    };

    const int V = sizeof(arr) / sizeof(arr[0]);
    const int H = sizeof(arr[0]) / sizeof(int);

    for (int i = 0; i < V; ++i) 
    {
        for (int j = 0; j < H; ++j)
        {
            std::cout 
                << "Pada index ke-" << i << "," << j << " adalah " << arr[i][j] 
                << std::endl;
        }
    }
}