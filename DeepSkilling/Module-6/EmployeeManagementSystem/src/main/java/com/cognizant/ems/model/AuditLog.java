package com.cognizant.ems.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.BatchSize;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Exercise 10 - Hibernate-Specific Features.
 *
 * @DynamicUpdate / @DynamicInsert make Hibernate build the SQL UPDATE /
 * INSERT statement with only the columns that actually changed / are
 * non-null, instead of always writing every column.
 *
 * @BatchSize lets Hibernate fetch this many AuditLog rows per SELECT
 * when lazily initializing a collection of them (works together with
 * hibernate.jdbc.batch_size in application.properties, which batches
 * the JDBC INSERT/UPDATE/DELETE statements themselves for bulk writes).
 */
@Entity
@Table(name = "audit_log")
@DynamicUpdate
@DynamicInsert
@BatchSize(size = 20)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AuditLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action;

    private String performedBy;
}
