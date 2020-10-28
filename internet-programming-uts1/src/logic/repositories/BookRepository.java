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
            "insert into tblBuku(idKategori, judul, penulis, harga, gambar) " +
            "values(?,?,?,?,?)");
        statement.setInt(1, data.catId);
        statement.setString(2, data.title);
        statement.setString(3, data.writer);
        statement.setDouble(4, data.price);
        statement.setString(5, data.imgPath);
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
            book.id = rs.getInt(1);
            book.catId = rs.getInt(2);
            book.title = rs.getString(3);
            book.writer = rs.getString(4);
            book.price = rs.getDouble(5);
            book.imgPath = rs.getString(6);
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
            book.id = rs.getInt(1);
            book.catId = rs.getInt(2);
            book.title = rs.getString(3);
            book.writer = rs.getString(4);
            book.price = rs.getDouble(5);
            book.imgPath = rs.getString(6);
            return book;
        }

        return null;
    }

    @Override
    public void update(Book data) 
    throws SQLException, Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatementReturn(
            "update tblBuku set idKategori = ?, judul = ?, penulis = ?, harga = ?, gambar = ? where id = ?");
        statement.setInt(1, data.catId);
        statement.setString(2, data.title);
        statement.setString(3, data.writer);
        statement.setDouble(4, data.price);
        statement.setString(5, data.imgPath);
        statement.setInt(6, data.id);
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

    @Override
    public void deleteByCategory(int id) 
    throws Exception 
    {
        DB db = new DB();
        PreparedStatement statement = db.prepareStatement(
            "delete from tblBuku where idKategori = ?");
        statement.setInt(1, id);
        statement.executeQuery();
    }

}
