package com.cognizant.ems.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Exercise 2 - Employee entity: id, name, email, department (ManyToOne).
 * Exercise 5 - Named Queries defined with @NamedQuery / @NamedQueries.
 * Exercise 7 - Entity Auditing fields.
 */
@Entity
@Table(name = "employee")
@EntityListeners(AuditingEntityListener.class)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "department")
@NamedQueries({
        @NamedQuery(
                name = "Employee.findByDepartmentName",
                query = "SELECT e FROM Employee e WHERE e.department.name = :departmentName"),
        @NamedQuery(
                name = "Employee.findAllOrderByNameAsc",
                query = "SELECT e FROM Employee e ORDER BY e.name ASC")
})
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    // Exercise 7 - Entity Auditing
    @CreatedBy
    private String createdBy;

    @CreatedDate
    private LocalDateTime createdDate;

    @LastModifiedBy
    private String lastModifiedBy;

    @LastModifiedDate
    private LocalDateTime lastModifiedDate;
}
