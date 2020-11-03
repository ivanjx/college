package logic.repositories;

import logic.models.Book;

public interface IBookRepository 
{
    Book create(Book data) throws Exception;
    Book[] list() throws Exception;
    Book get(int id) throws Exception;
    void update(Book data) throws Exception;
    void delete(int id) throws Exception;
    void deleteByCategory(int id) throws Exception;
}
