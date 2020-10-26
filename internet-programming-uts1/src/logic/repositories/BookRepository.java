package logic.repositories;

import logic.models.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository {

    @Override
    public Book[] list() 
    throws SQLException 
    {
        DB db = new DB();
        ResultSet rs = db.getStatement().executeQuery("select * from tblBuku");
        List<Book> result = new ArrayList<Book>();
        
        while (rs.next())
        {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setCatId(rs.getInt(2));
            book.setTitle(rs.getString(3));
            book.setWriter(rs.getString(4));
            book.setPrice(rs.getDouble(5));
            book.setImgPath(rs.getString(6));
            result.add(book);
        }

        return result.toArray(new Book[0]);
    }

    @Override
    public Book get(int id) 
    throws SQLException 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement("select * from tblBuku where id = ?");
        statement.setInt(1, id);
        ResultSet rs = statement.executeQuery();
        
        if (rs.next())
        {
            Book book = new Book();
            book.setId(rs.getInt(1));
            book.setCatId(rs.getInt(2));
            book.setTitle(rs.getString(3));
            book.setWriter(rs.getString(4));
            book.setPrice(rs.getDouble(5));
            book.setImgPath(rs.getString(6));
            return book;
        }

        return null;
    }

}
