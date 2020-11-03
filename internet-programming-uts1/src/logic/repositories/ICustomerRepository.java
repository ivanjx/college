package logic.repositories;

import logic.models.Customer;

public interface ICustomerRepository 
{
    Customer create(Customer data) throws Exception;
    Customer[] list() throws Exception;
    Customer get(int id) throws Exception;
    void update(Customer data) throws Exception;
    void delete(int id) throws Exception;
}
