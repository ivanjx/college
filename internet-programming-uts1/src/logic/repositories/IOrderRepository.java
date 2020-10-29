package logic.repositories;

import logic.models.Order;

public interface IOrderRepository 
{
    Order create(Order data) throws Exception;
    Order[] list() throws Exception;
    Order get(int id) throws Exception;
    void deleteByBook(int id) throws Exception;
    void deleteByBookCategory(int id) throws Exception;
    void deleteByCustomer(int id) throws Exception;
}
