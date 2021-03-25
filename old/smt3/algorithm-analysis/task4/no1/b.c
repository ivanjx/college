#include <stdio.h>
#include <conio.h>

int main()
{
    int n;
    scanf("%d", &n);
    
    if (n > 50)
    {
        n -= 25;
    }
    else
    {
        n += 10;
    }
    
    printf("%d\n", n);
    getch();

    return 0;
}