package logic.models;

public class Customer 
{
    int _id;
    String _name;
    String _address;
    String _phone;
    
    public int getId()
    {
        return _id;
    }

    public void setId(int id)
    {
        _id = id;
    }

    public String getName()
    {
        return _name;
    }

    public void setName(String name)
    {
        _name = name;
    }

    public String getAddress()
    {
        return _address;
    }

    public void setAddress(String address)
    {
        _address = address;
    }

    public String getPhone()
    {
        return _phone;
    }

    public void setPhone(String phone)
    {
        _phone = phone;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == this)
        {
            return true;
        }

        if (!(obj instanceof Customer))
        {
            return false;
        }

        Customer cust = (Customer)obj;

        return 
            getId() == cust.getId() &&
            getName() == cust.getName() &&
            getAddress() == cust.getAddress() &&
            getPhone() == cust.getPhone();
    }
}
