package com.library.repository;

import com.library.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Exercise 9: Spring Data JPA repository - CRUD methods are provided
 * automatically by extending JpaRepository.
 */
@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
