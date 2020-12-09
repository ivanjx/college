package logic.services;

import logic.models.Customer;
import logic.repositories.ICustomerRepository;
import logic.repositories.IOrderRepository;

public class CustomerService 
{
    ICustomerRepository _custRepo;
    IOrderRepository _orderRepo;

    public CustomerService(
        ICustomerRepository custRepo,
        IOrderRepository orderRepo)
    {
        _custRepo = custRepo;
        _orderRepo = orderRepo;
    }

    void validate(Customer data)
    throws Exception
    {
        if (data == null)
        {
            throw new Exception("data is null");
        }

        if (data.name == null ||
            data.name.trim().isEmpty())
        {
            throw new Exception("name is empty");
        }
    }

    public Customer create(Customer data)
    throws Exception
    {
        // Validating.
        validate(data);

        // Adding.
        return _custRepo.create(data);
    }

    public void update(Customer data)
    throws Exception
    {
        // Validating.
        validate(data);

        // Updating.
        _custRepo.update(data);
    }

    public void delete(int id)
    throws Exception
    {
        // Deleting orders.
        _orderRepo.deleteByCustomer(id);

        // Deleting customer.
        _custRepo.delete(id);
    }
}
