package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    // Search text box: matching countries containing the given text
    // e.g. findByNameContaining("ou") -> Bouvet Island, Djibouti, Guadeloupe...
    List<Country> findByNameContaining(String text);

    // Same as above but returned in ascending order by name
    List<Country> findByNameContainingOrderByNameAsc(String text);

    // Alphabet index: all countries whose name starts with the given letter,
    // returned in ascending order. e.g. findByNameStartingWithOrderByNameAsc("Z")
    // -> Zambia, Zimbabwe
    List<Country> findByNameStartingWithOrderByNameAsc(String letter);
}
