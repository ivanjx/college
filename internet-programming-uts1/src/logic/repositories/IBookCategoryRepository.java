package logic.repositories;

import logic.models.BookCategory;

public interface IBookCategoryRepository 
{
    BookCategory[] list() throws Exception;
    BookCategory get(int id) throws Exception;
}
