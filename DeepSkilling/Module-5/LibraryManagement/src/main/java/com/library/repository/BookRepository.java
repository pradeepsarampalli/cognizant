package com.library.repository;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Exercise 1: Basic repository class managed by the Spring container.
 * Exercise 6: Annotated with @Repository so it can be discovered by
 * component scanning instead of being declared explicitly in XML.
 */
@Repository
public class BookRepository {

    private final List<String> books = new ArrayList<>(
            Arrays.asList("Effective Java", "Clean Code", "Spring in Action")
    );

    public List<String> findAllBooks() {
        return books;
    }

    public void addBook(String title) {
        books.add(title);
    }

    public boolean deleteBook(String title) {
        return books.remove(title);
    }
}
