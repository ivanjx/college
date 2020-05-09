#include <iostream>
#include <stdlib.h>

typedef struct _MAHASISWA
{
    char nama[100];
    char nim[30];
    char jurusan[100];
} MAHASISWA;

void MAHASISWA_print(MAHASISWA *mhs)
{
    std::cout << "Nama: " << mhs->nama << std::endl;
    std::cout << "NIM: " << mhs->nim << std::endl;
    std::cout << "Jurusan: " << mhs->jurusan << std::endl;
}

void MAHASISWA_input(MAHASISWA *mhs)
{
    std::cout << "Nama: ";
    std::cin >> mhs->nama;

    std::cout << "NIM: ";
    std::cin >> mhs->nim;

    std::cout << "Jurusan: ";
    std::cin >> mhs->jurusan;
}

typedef struct _NODE
{
    MAHASISWA *element;
    struct _NODE *next;
} NODE;

void NODE_init(NODE *node, MAHASISWA *elem)
{
    node->element = elem;
    node->next = NULL;
}

typedef struct _LIST
{
    int count;
    NODE *head;
    NODE *tail;
} LIST;

void LIST_init(LIST *list)
{
    list->count = 0;
    list->head = NULL;
    list->tail = NULL;
}

int LIST_print(LIST *list)
{
    if (list->head == NULL)
    {
        std::cout << "Tidak ada data dalam list." << std::endl;
        return -1;
    }

    NODE *node = list->head;

    while (node != NULL)
    {
        MAHASISWA_print(node->element);
        std::cout << std::endl;

        node = node->next;
    }
}

void LIST_add(LIST *list, NODE *node)
{
    if (list->head == NULL)
    {
        list->head = node;
        list->tail = node;
    }
    else
    {
        list->tail->next = node;
        list->tail = node;
    }

    list->count++;
}

int LIST_remove(LIST *list, int index)
{
    if (list->head == NULL)
    {
        std::cout << "Tidak ada data dalam list." << std::endl;
        return -1;
    }

    if (index >= list->count)
    {
        std::cout << "Indeks tidak valid." << std::endl;
        return -1;
    }
    
    int i = 0;
    NODE *prev = NULL;
    NODE *node = list->head;

    while(i != index)
    {
        prev = node;
        node = node->next;
        i++;
    }

    if (prev != NULL)
    {
        prev->next = node->next;
    }
    else
    {
        list->head = node->next;
    }
    
    if (index == list->count - 1)
    {
        list->tail = node->next;
    }

    list->count--;

    if(list->count == 1)
    {
        list->tail = list->head;
    }

    return 0;
}

void printMenu()
{
    std::cout
        << "Menu:" << std::endl
        << "1. Cetak data" << std::endl
        << "2. Input data" << std::endl
        << "3. Hapus data" << std::endl
        << "4. Exit" << std::endl;
}

int main()
{
    std::cout
        << ".:Program Data Mahasiswa:."
        << std::endl
        << std::endl;

    
    LIST list;
    LIST_init(&list);

    char keluar;

    do
    {
        fflush(stdin);
        system("cls");

        printMenu();

        std::cout << "Pilihan anda: ";
        char pilihan;
        std::cin >> pilihan;

        if (pilihan == '1')
        {
            LIST_print(&list);
        }
        else if (pilihan == '2')
        {
            MAHASISWA *mhs = (MAHASISWA *)malloc(sizeof(MAHASISWA));
            MAHASISWA_input(mhs);
   
            NODE *node = (NODE *)malloc(sizeof(NODE));
            NODE_init(node, mhs);

            LIST_add(&list, node);
        }
        else if (pilihan == '3')
        {
            LIST_print(&list);

            std::cout << "Data yang mau dihapus data ke: ";
            int index;
            std::cin >> index;
            index--;

            LIST_remove(&list, index);
        }
        else if (pilihan == '4')
        {
            break;
        }

        std::cout 
            << std::endl
            << "Mau keluar? (y/n): ";
        std::cin >> keluar;
    } 
    while (keluar != 'Y' || 'y');
    
}