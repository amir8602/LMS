package service.impl;

import domain.Book;
import repository.BookRepository;
import service.BookService;
import java.util.Optional;

public class BookServiceImpl implements BookService {

     BookRepository bookRepository = new BookRepository();

    @Override
    public Book creatBook(Book book) {
        return bookRepository.creatBook(book);
    }

    @Override
    public Optional<Book> getBookById(Long Id) {
        return bookRepository.getBookById(Id);
    }

    @Override
    public Optional<Book> getBookByName(String name) {
        return bookRepository.getBookByName(name);
    }

    @Override
    public Book updateBook(Book book) {
        return bookRepository.updateBook(book);
    }

    @Override
    public void deleteBook(Long Id) {
        bookRepository.deleteBook(Id);
    }
}

//    @Override
//    public Optional<List<Book>> getBookByPojo(Book book) {
//        return bookRepository.getBookByPojo(book);
//    }
//
//    @Override
//    public Optional<List<Book>> getAllBook() {
//        return bookRepository.getAllBook();
//    }
//@Override
//public Optional<List<Book>> getBookBySearchSubName(String subName) {
//    return bookRepository.getBookBySearchSubName(subName);
//}
