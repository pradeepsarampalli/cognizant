package com.cognizant.ems.projection;

import lombok.Getter;
import lombok.ToString;

/**
 * Exercise 8 - Class-based projection (DTO). Populated via a JPQL
 * constructor expression, e.g.:
 *
 * SELECT new com.cognizant.ems.projection.EmployeeNameOnly(e.id, e.name)
 * FROM Employee e
 */
@Getter
@ToString
public class EmployeeNameOnly {

    private final Long id;
    private final String name;

    public EmployeeNameOnly(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
