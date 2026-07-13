package com.cognizant.ems.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.projection.EmployeeNameOnly;
import com.cognizant.ems.projection.EmployeeSummary;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // ---------------------------------------------------------------
    // Exercise 3 - Derived Query Methods
    // ---------------------------------------------------------------
    List<Employee> findByNameContainingIgnoreCase(String name);

    List<Employee> findByDepartmentId(Long departmentId);

    // ---------------------------------------------------------------
    // Exercise 5 - Query Methods (@Query) and Named Queries
    // ---------------------------------------------------------------
    @Query("SELECT e FROM Employee e WHERE e.email = :email")
    Employee findByEmailAddress(@Param("email") String email);

    // Backed by the @NamedQuery "Employee.findByDepartmentName" declared
    // on the Employee entity - Spring Data resolves it by the
    // <EntityName>.<methodName> naming convention automatically, so no
    // @Query annotation is required here.
    List<Employee> findByDepartmentName(String departmentName);

    // ---------------------------------------------------------------
    // Exercise 6 - Pagination and Sorting
    // ---------------------------------------------------------------
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    // ---------------------------------------------------------------
    // Exercise 8 - Projections
    // ---------------------------------------------------------------
    // Interface-based (open/closed) projection
    List<EmployeeSummary> findByDepartment_Id(Long departmentId);

    // Class-based projection via JPQL constructor expression
    @Query("SELECT new com.cognizant.ems.projection.EmployeeNameOnly(e.id, e.name) FROM Employee e")
    List<EmployeeNameOnly> findAllNamesOnly();
}
