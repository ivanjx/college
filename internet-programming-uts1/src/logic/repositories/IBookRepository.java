package logic.repositories;

import logic.models.Book;

public interface IBookRepository 
{
    Book[] list() throws Exception;
    Book get(int id) throws Exception;
}
