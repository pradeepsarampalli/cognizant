package com.library;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Exercise 9: Entry point for the Spring Boot application.
 * On startup, a couple of sample books are inserted so that GET
 * /api/books returns data immediately.
 */
@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    @Bean
    public CommandLineRunner loadData(BookRepository bookRepository) {
        return args -> {
            bookRepository.save(new Book("Effective Java", "Joshua Bloch"));
            bookRepository.save(new Book("Clean Code", "Robert C. Martin"));
            bookRepository.save(new Book("Spring in Action", "Craig Walls"));
        };
    }
}
