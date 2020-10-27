package logic.repositories;

import logic.models.BookCategory;
import java.sql.*;
import java.util.*;

public class BookCategoryRepository implements IBookCategoryRepository 
{

    @Override
    public BookCategory create(BookCategory data)
    throws SQLException, Exception
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatementReturn(
            "insert into tblKategori(nama) values (?)");
        statement.setString(1, data.name);
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
    public BookCategory[] list() 
    throws SQLException
    {
        DB db = new DB();
        Statement statement = db.getStatement();
        ResultSet rs = statement.executeQuery("select * from tblKategori");
        List<BookCategory> result = new ArrayList<BookCategory>();
        
        while (rs.next())
        {
            BookCategory cat = new BookCategory();
            cat.id = rs.getInt(1);
            cat.name = rs.getString(2);
            result.add(cat);
        }

        return result.toArray(new BookCategory[0]);
    }

    @Override
    public BookCategory get(int id)
    throws SQLException 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement("select * from tblKategori where id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();

        if (rs.next())
        {
            BookCategory cat = new BookCategory();
            cat.id = rs.getInt(1);
            cat.name = rs.getString(2);
            return cat;
        }

        return null;
    }

    @Override
    public void update(BookCategory data) 
    throws SQLException, Exception
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement(
            "update tblKategori set nama = ? where id = ?");
        statement.setString(1, data.name);
        statement.setInt(2, data.id);
        int count = statement.executeUpdate();

        if (count != 1)
        {
            throw new Exception("Unable to update data");
        }
    }

    @Override
    public void delete(int id) 
    throws SQLException 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement("delete from tblKategori where id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

}
