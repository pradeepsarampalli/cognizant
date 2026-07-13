package com.cognizant.ormlearn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Attempt;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Integer> {

    // Hands on 3 - Fetch quiz attempt details using HQL.
    // Joins: user -> attempt -> attempt_question -> question ->
    //        attempt_option -> options, in that order, with 'fetch' on
    // every one-to-many / many-to-many hop so everything is populated in
    // a single query.
    @Query(value = "SELECT a FROM Attempt a "
            + "join fetch a.user u "
            + "join fetch a.attemptQuestionList aq "
            + "join fetch aq.question q "
            + "join fetch aq.attemptOptionList ao "
            + "join fetch ao.option o "
            + "WHERE u.id = :userId AND a.id = :attemptId")
    Attempt getAttempt(@Param("userId") int userId, @Param("attemptId") int attemptId);
}
