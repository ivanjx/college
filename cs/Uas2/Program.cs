using System;

namespace Uas2
{
    class Program
    {
        static void PrintTitle()
        {
            Console.WriteLine("                   CAFE FRIED CHICKEN IVAN                   ");
        }

        static void PrintBoldLine()
        {
            Console.WriteLine("=============================================================");
        }

        static void PrintMenuTitle()
        {
            
            Console.WriteLine("No.  JENIS       HARGA       BANYAK      JUMLAH");
            Console.WriteLine("     POTONGAN    SATUAN      BELI        HARGA");
            Console.WriteLine("-------------------------------------------------------------");

        }

        static void PrintMenu()
        {
            PrintBoldLine();
            PrintMenuTitle();

            PrintBoldLine();
        }

        static void Main(string[] args)
        {
            PrintTitle();
            PrintMenu();

            
        }
    }
}
