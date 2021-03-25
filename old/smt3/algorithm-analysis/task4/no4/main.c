#include <stdio.h>
#include <conio.h>

int main()
{
    int a, b, c;
    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);

    if (a == b)
    {
        if (b == c)
        {
            printf("SAMA SISI\n");
        }
        else
        {
            printf("SAMA KAKI\n");
        }
    }
    else if (a == c)
    {
        printf("SAMA KAKI\n");
    }
    else if (b == c)
    {
        printf("SAMA KAKI\n");
    }
    else
    {
        printf("SEMBARANG\n");
    }    
    
    getch();
    return 0;
}