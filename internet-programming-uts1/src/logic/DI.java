package logic;

import logic.repositories.*;
import logic.services.*;

public class DI 
{
    public static IBookCategoryRepository bookCategoryRepository;
    public static IBookRepository bookRepository;
    public static ICustomerRepository customerRepository;
    public static IOrderRepository orderRepository;

    public static BookCategoryService bookCategoryService;
    public static BookService bookService;
    public static CustomerService customerService;
    public static OrderService orderService;

    static
    {
        // Repositories.
        bookCategoryRepository = new BookCategoryRepository();
        bookRepository = new BookRepository();
        customerRepository = new CustomerRepository();
        orderRepository = new OrderRepository();

        // Services.
        bookCategoryService = new BookCategoryService(bookCategoryRepository);
        bookService = new BookService(bookRepository, bookCategoryRepository);
        customerService = new CustomerService(customerRepository);
        orderService = new OrderService(
            orderRepository, 
            bookRepository, 
            customerRepository);
    }
}
