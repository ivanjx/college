package logic.models;

import java.util.Date;

public class Order 
{
    int _id;
    int _custId;
    int _bookId;
    int _amount;
    Date _date;

    public int getId()
    {
        return _id;
    }

    public void setId(int id)
    {
        _id = id;
    }

    public int getCustId()
    {
        return _custId;
    }

    public void setCustId(int custId)
    {
        _custId = custId;
    }

    public int getBookId()
    {
        return _bookId;
    }

    public void setBookId(int bookId)
    {
        _bookId = bookId;
    }

    public int getAmount()
    {
        return _amount;
    }

    public void setAmount(int amount)
    {
        _amount = amount;
    }

    public Date getDate()
    {
        return _date;
    }

    public void setDate(Date date)
    {
        _date = date;
    }

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
            getId() == order.getId() &&
            getCustId() == order.getCustId() &&
            getBookId() == order.getBookId() &&
            getAmount() == order.getAmount() &&
            getDate() == order.getDate();
    }
}
