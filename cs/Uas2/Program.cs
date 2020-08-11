using System;
using System.Collections.Generic;

namespace Uas2
{
    class Item
    {
        public string Code
        {
            get;
            set;
        }

        public string Name
        {
            get;
            set;
        }

        public double Price
        {
            get;
            set;
        }

        public Item(string code, string name, double price)
        {
            Code = code;
            Name = name;
            Price = price;
        }
    }

    class Menu
    {
        public List<Item> Items 
        {
            get;
            set;
        }

        public Menu()
        {
            Items = new List<Item>();
        }

        public void AddMenuItem(string code, string name, double price)
        {
            Items.Add(new Item(code, name, price));
        }
    }

    class OrderItem
    {
        public Item Item 
        {
            get;
            set;
        }

        public int Qty
        {
            get;
            set;
        }

        public double TotalPrice
        {
            get
            {
                return Qty * Item.Price;
            }
        }

        public OrderItem(Item item, int qty)
        {
            Item = item;
            Qty = qty;
        }
    }

    class Order 
    {
        public OrderItem[] Items 
        {
            get;
            set;
        }

        public double SubTotal
        {
            get
            {
                double total = 0;

                foreach (OrderItem item in Items)
                {
                    total += item.TotalPrice;
                }

                return total;
            }
        }

        public double Tax
        {
            get
            {
                return SubTotal * 0.1;
            }
        }

        public double Total
        {
            get
            {
                return SubTotal + Tax;
            }
        }

        public Order(int n)
        {
            Items = new OrderItem[n];
        }
    }

    class MenuUI
    {
        public Menu Menu 
        {
            get;
            set;
        }

        public MenuUI(Menu menu)
        {
            Menu = menu;
        }

        void PrintTitle()
        {
            Console.WriteLine("            CAFE FRIED CHICKEN IVAN            ");
        }

        void PrintLine()
        {
            Console.WriteLine("-----------------------------------------------");
        }

        void PrintBoldLine()
        {
            Console.WriteLine("===============================================");
        }

        void PrintMenuHeader()
        {
            Console.WriteLine(" KODE\t\tJENIS\t\tHARGA");
        }

        void PrintMenuItems()
        {
            foreach(Item item in Menu.Items)
            {
                Console.WriteLine("  {0}\t\t{1}\t\tRp. {2:n0}",
                    item.Code,
                    item.Name,
                    item.Price);
            }
        }

        public void PrintMenu()
        {
            PrintTitle();
            PrintBoldLine();
            PrintMenuHeader();
            PrintLine();
            PrintMenuItems();
            PrintBoldLine();
        }
    }

    class NewOrderUI
    {
        public Menu Menu 
        {
            get;
            set;
        }

        public NewOrderUI(Menu menu)
        {
            Menu = menu;
        }

        int PromptOrderItemsCount()
        {
            Console.Write(" BANYAK JENIS = ");
            return int.Parse(Console.ReadLine());
        }

        string GetMenuCodes()
        {
            string result = "[ ";

            foreach (Item item in Menu.Items)
            {
                result += item.Code + " / ";
            }

            result = result.Substring(0, result.Length - 2);
            result += "]";
            return result;
        }

        Item GetItemByCode(string code)
        {
            code = code.Trim();
            code = code.ToUpper();

            foreach (Item item in Menu.Items)
            {
                if (item.Code == code)
                {
                    return item;
                }
            }

            throw new Exception("Kode invalid");
        }

        OrderItem PromptOrderItem(int i)
        {
            Console.WriteLine(" JENIS KE - {0}", i);
            Console.WriteLine();

            Console.Write(" JENIS POTONGAN {0}\t\t:  ", GetMenuCodes());
            Item item = GetItemByCode(Console.ReadLine());
            
            Console.Write(" BANYAK POTONGAN\t\t\t:  ");
            int qty = int.Parse(Console.ReadLine());

            return new OrderItem(item, qty);
        }

        void PrintEmote()
        {
            Console.WriteLine("                     ^_^                       ");
        }

        void PrintLine()
        {
            Console.WriteLine("-----------------------------------------------");
        }

        public Order PromptNewOrder()
        {
            int nitems = PromptOrderItemsCount();
            Order order = new Order(nitems);
            PrintLine();

            for (int i = 1; i <= nitems; ++i)
            {
                order.Items[i - 1] = PromptOrderItem(i);
                PrintLine();
            }

            PrintEmote();

            return order;
        }
    }

    class OrderUI 
    {
        void PrintTitle()
        {
            Console.WriteLine("                    CAFE     FRIED    CHICKEN      IVAN                         ");
        }

        void PrintLine()
        {
            Console.WriteLine("--------------------------------------------------------------------------------");
        }

        void PrintBoldLine()
        {
            Console.WriteLine("================================================================================");
        }

        void PrintFooter()
        {
            Console.WriteLine("                     = Terima Kasih Atas Kunjungannya =                         ");
            Console.WriteLine("                                     ^_^                                        ");
        }

        void PrintTotals(Order order)
        {
            Console.WriteLine("                                       JUMLAH BAYAR  :  Rp. {0:n0}", order.SubTotal);
            Console.WriteLine("                                       PAJAK  10 %   :  Rp. {0:n0}", order.Tax);
            Console.WriteLine("                                       TOTAL BAYAR   :  Rp. {0:n0}", order.Total);
        }

        void PrintTableHeader()
        {
            Console.WriteLine("No.\tJENIS\t\tHARGA\t\tBANYAK\t\tJUMLAH");
            Console.WriteLine("\tPOTONGAN\tSATUAN\t\tBELI\t\tHARGA");
        }

        void PrintOrderItem(OrderItem orderItem, int i)
        {
            Console.WriteLine(" {0}\t{1}\t\t{2}\t\t{3}\t\tRp. {4:n0}",
                i,
                orderItem.Item.Name,
                orderItem.Item.Price,
                orderItem.Qty,
                orderItem.TotalPrice);
        }

        void PrintOrderItems(Order order)
        {
            for (int i = 1; i <= order.Items.Length; ++i)
            {
                PrintOrderItem(order.Items[i - 1], i);
            }
        }

        public void PrintOrder(Order order)
        {
            PrintTitle();

            PrintBoldLine();
            PrintTableHeader();
            PrintLine();
            
            PrintOrderItems(order);
            PrintBoldLine();

            PrintTotals(order);
            PrintBoldLine();
            
            PrintFooter();
        }
    }

    class Program
    {
        static void Main(string[] args)
        {
            // Init.
            Menu menu = new Menu();
            menu.AddMenuItem("D", "DADA", 6000);
            menu.AddMenuItem("P", "PAHA", 5000);
            menu.AddMenuItem("S", "SAYAP", 4000);
            
            // Print menu.
            MenuUI menuUI = new MenuUI(menu);
            menuUI.PrintMenu();

            // Get order.
            NewOrderUI newOrderUI = new NewOrderUI(menu);
            Order order = newOrderUI.PromptNewOrder();
            Console.WriteLine();
            Console.WriteLine();

            // Print order.
            OrderUI orderUI = new OrderUI();
            orderUI.PrintOrder(order);
        }
    }
}
