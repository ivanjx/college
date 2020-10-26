package logic.repositories;

import logic.models.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookRepository implements IBookRepository 
{

    @Override
    public Book create(Book data)
    throws SQLException, Exception
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatementReturn(
            "insert into tblBuku(catId, judul, penulis, harga, gambar) " +
            "values(?,?,?,?,?)");
        statement.setInt(1, data.getCatId());
        statement.setString(2, data.getTitle());
        statement.setString(3, data.getWriter());
        statement.setDouble(4, data.getPrice());
        statement.setString(5, data.getImgPath());
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

    @Override
    public void update(Book data) 
    throws SQLException, Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement(
            "update tblBuku set catId = ?, judul = ?, penulis = ?, harga = ?, gambar = ? where id = ?");
        statement.setInt(1, data.getCatId());
        statement.setString(2, data.getTitle());
        statement.setString(3, data.getWriter());
        statement.setDouble(4, data.getPrice());
        statement.setString(5, data.getImgPath());
        statement.setInt(6, data.getId());
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
        PreparedStatement statement = db.prepareStatement("delete from tblBuku where id = ?");
        statement.setInt(1, id);
        statement.executeUpdate();
    }

}
