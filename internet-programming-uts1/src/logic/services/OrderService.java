package logic.services;

import java.sql.Date;

import logic.models.Book;
import logic.models.Customer;
import logic.models.Order;
import logic.repositories.IBookRepository;
import logic.repositories.ICustomerRepository;
import logic.repositories.IOrderRepository;

public class OrderService 
{
    IOrderRepository _orderRepo;
    IBookRepository _bookRepo;
    ICustomerRepository _custRepo;

    public OrderService(
        IOrderRepository orderRepo,
        IBookRepository bookRepo,
        ICustomerRepository custRepo)
    {
        _orderRepo = orderRepo;
        _bookRepo = bookRepo;
        _custRepo = custRepo;
    }

    void validate(Order data)
    throws Exception
    {
        if (data == null)
        {
            throw new Exception("data is null");
        }

        Book book = _bookRepo.get(data.bookId);
        
        if (book == null)
        {
            throw new Exception("invalid book id");
        }

        Customer cust = _custRepo.get(data.custId);

        if (cust == null)
        {
            throw new Exception("invalid customer id");
        }

        if (data.amount < 1)
        {
            throw new Exception("invalid amount");
        }
    }

    public Order create(Order data)
    throws Exception
    {
        // Validating.
        validate(data);

        // Setting date.
        data.date = new Date(System.currentTimeMillis());

        // Creating.
        return _orderRepo.create(data);
    }

    public void update(Order data)
    throws Exception
    {
        // Validating.
        validate(data);

        // Updating.
        _orderRepo.update(data);
    }
}
