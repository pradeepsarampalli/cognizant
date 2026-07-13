package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // ---------------------------------------------------------------
    // Hands on 2 - Get all permanent employees using HQL
    //
    // Final (optimized) version: 'join fetch' is used so department and
    // skillList are populated in a single SQL query instead of the N+1
    // queries that eager-fetch mapping alone produces.
    // ---------------------------------------------------------------
    @Query(value = "SELECT e FROM Employee e left join fetch e.department d "
            + "left join fetch e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // ---------------------------------------------------------------
    // Hands on 4 - Average salary using HQL aggregate function
    // ---------------------------------------------------------------
    @Query(value = "SELECT AVG(e.salary) FROM Employee e")
    double getAverageSalary();

    @Query(value = "SELECT AVG(e.salary) FROM Employee e where e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // ---------------------------------------------------------------
    // Hands on 5 - Native Query
    // ---------------------------------------------------------------
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
