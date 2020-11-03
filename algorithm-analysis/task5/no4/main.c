#include <stdio.h>

int main()
{
    printf("Mata kuliah: ");
    char matakuliah[60];
    
    if (fgets(matakuliah, sizeof(matakuliah), stdin) == NULL)
    {
        return -1;
    }

    printf("SKS: ");
    int sks;
    scanf("%d", &sks);

    printf("Nilai: ");
    int nilai;
    scanf("%d", &nilai);

    if (nilai >= 90)
    {
        printf("A+\n");
    }
    else if (nilai >= 80)
    {
        printf("A\n");
    }
    else if (nilai >= 70)
    {
        printf("A-\n");
    }
    else if (nilai >= 60)
    {
        printf("B+\n");
    }
    else if (nilai >= 50)
    {
        printf("B\n");
    }
    else if (nilai >= 40)
    {
        printf("B-\n");
    }
    else if (nilai >= 30)
    {
        printf("C\n");
    }
    else
    {
        printf("D\n");
    }
}