#include <stdio.h>
#include <conio.h>

int main()
{
    int a, b, c;
    scanf("%d", &a);
    scanf("%d", &b);
    scanf("%d", &c);

    int count = 0;

    if (a >= 60) ++count;
    if (b >= 60) ++count;
    if (c >= 60) ++count;

    if (count == 0) printf("NOL\n");
    else if (count == 1) printf("SATU\n");
    else if (count == 2) printf("DUA\n");
    else if (count == 3) printf("TIGA\n");
    
    getch();
    return 0;
}