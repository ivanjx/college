package logic.repositories;

import logic.models.BookCategory;

public interface IBookCategoryRepository 
{
    BookCategory[] list() throws Exception;
    BookCategory get(int id) throws Exception;
    void update(BookCategory data) throws Exception;
    void delete(int id) throws Exception;
}
