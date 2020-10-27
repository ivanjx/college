package logic.services;

import logic.models.BookCategory;
import logic.repositories.IBookCategoryRepository;

public class BookCategoryService 
{
    IBookCategoryRepository _catRepo;

    public BookCategoryService(IBookCategoryRepository catRepo)
    {
        _catRepo = catRepo;
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
}
