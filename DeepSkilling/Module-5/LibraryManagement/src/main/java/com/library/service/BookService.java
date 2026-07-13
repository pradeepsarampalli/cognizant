package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Exercise 1: Service class managed by the Spring IoC container.
 * Exercise 2: Depends on BookRepository, wired through Spring's DI.
 * Exercise 6: Annotated with @Service for component scanning.
 * Exercise 7: Exposes BOTH a constructor and a setter for BookRepository so
 * the same class can be wired using either constructor injection or setter
 * injection, depending on which applicationContext XML is loaded.
 */
@Service
public class BookService {

    private BookRepository bookRepository;

    // No-arg constructor kept for pure setter-injection XML wiring
    // (see applicationContext.xml, Exercises 1, 2 and 5).
    public BookService() {
    }

    // Constructor used for constructor injection
    // (see applicationContext-constructor.xml, Exercise 7).
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Setter used for setter injection
    // (see applicationContext.xml <property> tag, Exercises 2, 5 and 7).
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<String> getAllBooks() {
        return bookRepository.findAllBooks();
    }

    public void addBook(String title) {
        bookRepository.addBook(title);
    }

    public boolean removeBook(String title) {
        return bookRepository.deleteBook(title);
    }
}
