package logic.services;

import logic.models.Book;
import logic.models.BookCategory;
import logic.repositories.IBookCategoryRepository;
import logic.repositories.IBookRepository;

public class BookService 
{
    IBookRepository _bookRepo;
    IBookCategoryRepository _catRepo;

    public BookService(
        IBookRepository bookRepo,
        IBookCategoryRepository catRepo)
    {
        _bookRepo = bookRepo;
        _catRepo = catRepo;
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
}
