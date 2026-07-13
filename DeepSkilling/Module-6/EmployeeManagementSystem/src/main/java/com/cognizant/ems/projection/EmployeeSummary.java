package com.cognizant.ems.projection;

/**
 * Exercise 8 - Interface-based projection: only exposes name and the
 * department's name, letting Spring Data generate an optimized query
 * that does not fetch every Employee column.
 */
public interface EmployeeSummary {

    String getName();

    String getEmail();

    String getDepartmentName();
}
