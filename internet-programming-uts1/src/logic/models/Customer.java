package logic.models;

public class Customer 
{
    public int id;
    public String name;
    public String address;
    public String phone;

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
            id == cust.id &&
            name == cust.name &&
            address == cust.address &&
            phone == cust.phone;
    }
}
