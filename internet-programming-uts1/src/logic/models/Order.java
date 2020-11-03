package logic.models;

import java.util.Date;

public class Order 
{
    public int id;
    public int custId;
    public int bookId;
    public int amount;
    public Date date;

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof Order))
        {
            return false;
        }

        Order order = (Order)obj;

        return
            id == order.id &&
            custId == order.custId &&
            bookId == order.bookId &&
            amount == order.amount &&
            date == order.date;
    }
}
