package logic.services;

import logic.models.BookCategory;
import logic.repositories.IBookCategoryRepository;
import logic.repositories.IBookRepository;

public class BookCategoryService 
{
    IBookCategoryRepository _catRepo;
    IBookRepository _bookRepo;

    public BookCategoryService(
        IBookCategoryRepository catRepo,
        IBookRepository bookRepo)
    {
        _catRepo = catRepo;
        _bookRepo = bookRepo;
    }

    void validate(BookCategory data)
    throws Exception
    {
        if (data == null)
        {
            throw new Exception("data is null");
        }

        if (data.name == null || 
            data.name.trim().isEmpty())
        {
            throw new Exception("name is empty");
        }
    }

    public BookCategory create(BookCategory data)
    throws Exception
    {
        // Validating.
        validate(data);

        // Saving.
        return _catRepo.create(data);
    }

    public void update(BookCategory data)
    throws Exception
    {
        // Validating.
        validate(data);

        // Saving.
        _catRepo.update(data);
    }

    public void delete(int id)
    throws Exception
    {
        // Deleting books.
        _bookRepo.deleteByCategory(id);

        // Deleting category.
        _catRepo.delete(id);
    }
}
