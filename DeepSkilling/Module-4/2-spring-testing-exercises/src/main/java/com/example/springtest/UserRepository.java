package com.example.springtest;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // Custom query method used in Exercise 7
    List<User> findByName(String name);
}
