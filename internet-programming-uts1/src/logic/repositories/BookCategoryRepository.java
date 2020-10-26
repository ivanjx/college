package logic.repositories;

import logic.models.BookCategory;
import java.sql.*;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

public class BookCategoryRepository implements IBookCategoryRepository 
{

    @Override
    public BookCategory[] list() 
    throws SQLException
    {
        DB db = new DB();
        Statement statement = db.getStatement();
        ResultSet rs = statement.executeQuery("select * from tblBuku");
        List<BookCategory> result = new List<BookCategory>();
        
        while (rs.next())
        {
            BookCategory cat = new BookCategory();
            cat.setId(rs.getInt(1));
            cat.setName(rs.getString(2));
            result.add(cat);
        }

        return result.toArray();
    }

    @Override
    public BookCategory get(int id) 
    {
        // TODO Auto-generated method stub
        return null;
    }

}
