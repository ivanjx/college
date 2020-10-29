package logic.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import logic.models.Order;

public class OrderRepository implements IOrderRepository 
{

    @Override
    public Order create(Order data) 
    throws SQLException, Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatementReturn(
            "insert into tblPesan(idPembeli, idBuku, jumlah, tanggal) " +
            "values(?,?,?,?)");
        statement.setInt(1, data.custId);
        statement.setInt(2, data.bookId);
        statement.setInt(3, data.amount);
        statement.setLong(4, data.date.getTime());
        int count = statement.executeUpdate();

        if (count == 0)
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
    public Order[] list() 
    throws SQLException, ClassNotFoundException 
    {
        DB db = new DB();
        ResultSet rs = db.getStatement().executeQuery(
            "select * from tblPesan order by id desc");
        List<Order> result = new ArrayList<Order>();

        while (rs.next())
        {
            Order order = new Order();
            order.id = rs.getInt(1);
            order.custId = rs.getInt(2);
            order.bookId = rs.getInt(3);
            order.amount = rs.getInt(4);
            order.date = new Date(rs.getLong(5));
            result.add(order);
        }

        return result.toArray(new Order[0]);
    }

    @Override
    public Order get(int id) 
    throws SQLException, Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement(
            "select * from tblPesan where id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.next())
        {
            Order order = new Order();
            order.id = rs.getInt(1);
            order.custId = rs.getInt(2);
            order.bookId = rs.getInt(3);
            order.amount = rs.getInt(4);
            order.date = new Date(rs.getLong(5));
            return order;
        }

        return null;
    }

    @Override
    public void deleteByBook(int id) 
    throws Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement(
            "delete from tblPesan where idBuku = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public void deleteByCustomer(int id) 
    throws Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement(
            "delete from tblPesan where idPembeli = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    @Override
    public void deleteByBookCategory(int id)
    throws Exception
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement(
            "delete from tblPesan where idBuku in (select id from tblBuku where idKategori = ?)");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

    
}
