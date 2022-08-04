package service;

import domain.Book;

import java.util.Optional;

public interface BookService {

    Book creatBook(Book book);
    Optional<Book> getBookById(Long Id);
    Optional<Book> getBookByName(String name);
    Book updateBook(Book book);
    void deleteBook(Long Id);

}
//Optional<List<Book>> getBookByPojo(Book book);
//Optional<List<Book>> getAllBook();
//Optional<List<Book>> getBookBySearchSubName(String subName);