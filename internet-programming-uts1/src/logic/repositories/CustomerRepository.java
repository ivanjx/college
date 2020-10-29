package logic.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import logic.models.Customer;

public class CustomerRepository implements ICustomerRepository 
{

    @Override
    public Customer create(Customer data) 
    throws SQLException, Exception
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatementReturn(
            "insert into tblPembeli(nama, alamat, telp) " +
            "values(?,?,?)");
        statement.setString(1, data.name);
        statement.setString(2, data.address);
        statement.setString(3, data.phone);
        int count = statement.executeUpdate();

        if (count != 1)
        {
            throw new Exception("Unable to insert data");
        }

        ResultSet rs = statement.getGeneratedKeys();

        if (rs.next())
        {
            return get(rs.getInt(1));
        }

        throw new Exception("Unable to insert data");
    }

    @Override
    public Customer[] list() 
    throws SQLException, Exception 
    {
        DB db = new DB();
        ResultSet rs = db.getStatement().executeQuery("select * from tblPembeli");
        List<Customer> result = new ArrayList<Customer>();
        
        while (rs.next())
        {
            Customer cust = new Customer();
            cust.id = rs.getInt(1);
            cust.name = rs.getString(2);
            cust.address = rs.getString(3);
            cust.phone = rs.getString(4);
            result.add(cust);
        }

        return result.toArray(new Customer[0]);
    }

    @Override
    public Customer get(int id) 
    throws SQLException, Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement("select * from tblPembeli where id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        
        if (rs.next())
        {
            Customer cust = new Customer();
            cust.id = rs.getInt(1);
            cust.name = rs.getString(2);
            cust.address = rs.getString(3);
            cust.phone = rs.getString(4);
            return cust;
        }

        return null;
    }

    @Override
    public void update(Customer data) 
    throws SQLException, Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatementReturn(
            "update tblPembeli set nama = ?, alamat = ?, tlp = ? where id = ?");
        statement.setString(1, data.name);
        statement.setString(2, data.address);
        statement.setString(3, data.phone);
        statement.setInt(4, data.id);
        int count = statement.executeUpdate();

        if (count == 0)
        {
            throw new Exception("Unable to update data");
        }
    }

    @Override
    public void delete(int id)
    throws SQLException, Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement("delete from tblPembeli where id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

}