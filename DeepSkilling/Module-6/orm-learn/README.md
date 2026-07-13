# orm-learn

Solutions for the **Spring Data JPA & Hibernate** hands-on documents:

- `1__spring-data-jpa-handson` – ORM / Spring Data JPA basics, Country CRUD
- `2__spring-data-jpa-handson` – Query Methods (Country, Stock), O/R Mapping (Employee/Department/Skill)
- `3__spring-data-jpa-handson` – HQL / JPQL, Native Query, Criteria Query, Quiz schema

All three documents build on the **same** `orm-learn` project and database
schema, so they are implemented here together as one runnable Spring Boot
app.

## Running it

```bash
mvn spring-boot:run
```

The app uses an **H2 in-memory database** (schema + seed data are created
automatically on every run from `data.sql`) so it runs with zero setup.
`OrmLearnApplication.main()` runs every hands-on's test method in sequence
and logs the results (see `logging.level.com.cognizant=debug` in
`application.properties`).

To instead point at MySQL exactly as the original hand-on describes, see
the commented-out block in `src/main/resources/application.properties`
and the `mysql-connector-j` dependency already declared in `pom.xml`.

## Where each hands-on lives

| Hands-on | Topic | Files |
|---|---|---|
| Doc1 HO1 | Spring Data JPA quick example, Country entity/repo/service | `model/Country.java`, `repository/CountryRepository.java`, `service/CountryService.java` |
| Doc1 HO5–9 | Country CRUD (find/add/update/delete) | `service/CountryService.java`, `service/exception/CountryNotFoundException.java` |
| Doc2 HO1 | Query Methods – search box, sorting, alphabet index | `repository/CountryRepository.java` |
| Doc2 HO2 | Query Methods – stock (between dates, greater than, top N) | `model/Stock.java`, `repository/StockRepository.java`, `service/StockService.java` |
| Doc2 HO3 | Payroll schema (Employee/Department/Skill) bean mapping | `model/Employee.java`, `model/Department.java`, `model/Skill.java` |
| Doc2 HO4 | `@ManyToOne` / `@JoinColumn` (Employee → Department) | `model/Employee.java`, `service/EmployeeService.java`, `service/DepartmentService.java` |
| Doc2 HO5 | `@OneToMany` (Department → Employee), EAGER fetch | `model/Department.java` |
| Doc2 HO6 | `@ManyToMany` / `@JoinTable` (Employee ↔ Skill) | `model/Employee.java`, `model/Skill.java` |
| Doc3 HO2 | HQL with `@Query`, `join fetch` optimization | `repository/EmployeeRepository.java#getAllPermanentEmployees` |
| Doc3 HO3 | Multi-table HQL with fetch (quiz attempt schema) | `model/QuizUser.java`, `Question.java`, `Options.java`, `Attempt.java`, `AttemptQuestion.java`, `AttemptOption.java`, `repository/AttemptRepository.java` |
| Doc3 HO4 | Aggregate functions (`AVG`) + `@Param` | `repository/EmployeeRepository.java#getAverageSalary` |
| Doc3 HO5 | Native Query (`nativeQuery = true`) | `repository/EmployeeRepository.java#getAllEmployeesNative` |
| Doc3 HO6 | Criteria Query (dynamic filters) | `service/EmployeeCriteriaService.java` |

All test/driver code lives in `OrmLearnApplication.java`, mirroring the
`testXxx()` methods described in the hand-on documents.
