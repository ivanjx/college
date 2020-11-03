#include <stdio.h>

int main() 
{
    int masuk, keluar;
    printf("Jam masuk: ");
    scanf("%d", &masuk);
    printf("Jam keluar: ");
    scanf("%d", &keluar);
    keluar += 12;
    
    int lama = keluar - masuk;
    printf("Lama bekerja %d jam", lama);
}