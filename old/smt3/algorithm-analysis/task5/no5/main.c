#include <stdio.h>
#include <stdlib.h>

int main()
{
    printf("Kode: ");
    int kode;
    scanf(" %d", &kode);

    printf("Jenis: ");
    char jenis;
    scanf(" %c", &jenis);

    printf("Harga: ");
    int harga;
    scanf(" %d", &harga);

    int diskonp;

    switch (jenis)
    {
        case 'A':
            diskonp = 10;
            break;

        case 'B':
            diskonp = 15;
            break;

        case 'C':
            diskonp = 20;
            break;
    }

    int diskon = harga * diskonp / 100;
    int total = harga - diskon;
    printf("Jenis barang %c mendapat diskon %d%%, harga setelah didiskon: %d",
        jenis,
        diskonp,
        total);
}