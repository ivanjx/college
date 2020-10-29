package logic.repositories;

import logic.models.Order;

public interface IOrderRepository 
{
    Order create(Order data) throws Exception;
    Order[] list(int skip) throws Exception;
    Order get(int id) throws Exception;
    void update(Order data) throws Exception;
    void delete(int id) throws Exception;
    void deleteByBook(int id) throws Exception;
    void deleteByBookCategory(int id) throws Exception;
    void deleteByCustomer(int id) throws Exception;
}
