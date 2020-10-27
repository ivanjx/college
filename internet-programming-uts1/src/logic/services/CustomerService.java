package logic.services;

import logic.models.Customer;
import logic.repositories.ICustomerRepository;

public class CustomerService 
{
    ICustomerRepository _custRepo;

    public CustomerService(ICustomerRepository custRepo)
    {
        _custRepo = custRepo;
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
}
