package logic.services;

import logic.models.Book;
import logic.models.BookCategory;
import logic.repositories.IBookCategoryRepository;
import logic.repositories.IBookRepository;
import logic.repositories.IOrderRepository;

public class BookService 
{
    IBookRepository _bookRepo;
    IBookCategoryRepository _catRepo;
    IOrderRepository _orderRepo;

    public BookService(
        IBookRepository bookRepo,
        IBookCategoryRepository catRepo,
        IOrderRepository orderRepo)
    {
        _bookRepo = bookRepo;
        _catRepo = catRepo;
        _orderRepo = orderRepo;
    }

    void validate(Book data)
    throws Exception
    {
        if (data == null)
        {
            throw new Exception("data is null");
        }

        BookCategory cat = _catRepo.get(data.catId);

        if (cat == null)
        {
            throw new Exception("invalid category");
        }

        if (data.title == null ||
            data.title.trim().isEmpty())
        {
            throw new Exception("title is empty");
        }

        if (data.writer == null ||
            data.writer.trim().isEmpty())
        {
            throw new Exception("writer is empty");
        }

        if (data.price < 0)
        {
            throw new Exception("invalid price");
        }
    }

    public Book create(Book data)
    throws Exception
    {
        // Validating.
        validate(data);

        // Adding.
        return _bookRepo.create(data);
    }

    public void update(Book data)
    throws Exception
    {
        // Validating.
        validate(data);

        // Updating.
        _bookRepo.update(data);
    }

    public void delete(int id)
    throws Exception
    {
        // Deleting orders.
        _orderRepo.deleteByBook(id);

        // Deleting book.
        _bookRepo.delete(id);
    }
}
