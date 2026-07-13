# EmployeeManagementSystem

Solutions for the **Spring Data JPA and Hibernate — Employee Management
System** exercise document (Exercises 1–10).

## Running it

```bash
mvn spring-boot:run
```

Runs on `http://localhost:8080` against an in-memory H2 database seeded
from `data.sql`. Browse the schema/data at `http://localhost:8080/h2-console`
(JDBC URL `jdbc:h2:mem:testdb`, user `sa`, password `password`).

## Where each exercise lives

| Exercise | Topic | Files |
|---|---|---|
| 1 | Project setup, H2 config | `pom.xml`, `application.properties`, `EmployeeManagementSystemApplication.java` |
| 2 | JPA Entities & mapping | `model/Employee.java`, `model/Department.java` |
| 3 | Repositories | `repository/EmployeeRepository.java`, `repository/DepartmentRepository.java` |
| 4 | CRUD REST endpoints | `controller/EmployeeController.java`, `controller/DepartmentController.java` |
| 5 | Derived query methods, `@Query`, `@NamedQuery`/`@NamedQueries` | `repository/EmployeeRepository.java`, `@NamedQueries` on `model/Employee.java` |
| 6 | Pagination & sorting | `EmployeeController#getAll`, `#getByDepartmentPaged` |
| 7 | Entity auditing (`@CreatedBy`/`@CreatedDate`/...) | `config/AuditConfig.java`, auditing fields on `model/Employee.java` |
| 8 | Projections (interface- and class-based) | `projection/EmployeeSummary.java`, `projection/EmployeeNameOnly.java`, corresponding repository methods |
| 9 | Data source configuration / externalization | commented walkthrough in `application.properties` |
| 10 | Hibernate-specific features & batch processing | `model/AuditLog.java` (`@DynamicUpdate`, `@DynamicInsert`, `@BatchSize`), `hibernate.jdbc.batch_size` in `application.properties` |

## Sample REST calls

```bash
# CRUD
curl http://localhost:8080/api/employees/1
curl -X POST http://localhost:8080/api/employees \
     -H "Content-Type: application/json" \
     -d '{"name":"New Hire","email":"new.hire@example.com","department":{"id":1}}'

# Query methods
curl "http://localhost:8080/api/employees/search?name=ali"
curl "http://localhost:8080/api/employees/by-department-name?name=Engineering"

# Pagination + sorting
curl "http://localhost:8080/api/employees?page=0&size=2&sortBy=name&direction=asc"

# Projections
curl http://localhost:8080/api/employees/department/1/summary
curl http://localhost:8080/api/employees/names-only
```

## Notes on Exercise 9 (multiple data sources)

This project ships with a single auto-configured H2 `DataSource`, which
covers the "Spring Boot Auto-Configuration" and "Externalizing
Configuration" instructions directly. The `application.properties` file
includes a commented example of how you would extend this to a second,
manually-configured data source (separate `@ConfigurationProperties`
prefix + a dedicated `@Configuration` class exposing its own
`DataSource` / `EntityManagerFactory` / `PlatformTransactionManager`
beans), since wiring up a second real database is environment-specific.
