# spring-learn — Solutions

Complete working solution for the 5 hands-on documents:

1. `1__spring-rest-handson.docx` — Spring Boot basics, Spring Core (beans, XML config, scopes, logging)
2. `2__spring-rest-handson.docx` — HTTP/REST fundamentals, first GET services, MockMVC tests
3. `3__spring-rest-handson.docx` — Employee/Department REST services (Controller → Service → Dao)
4. `4__spring-rest-handson.docx` — POST/PUT/DELETE, `javax.validation`, global exception handling
5. `5__JWT-handson.docx` — Spring Security (HTTP Basic → roles) + JWT authentication/authorization

## Project layout

```
src/main/java/com/cognizant/springlearn/
├── SpringLearnApplication.java      # main class + displayDate/displayCountry/displayCountries (doc 1)
├── GlobalExceptionHandler.java      # @ControllerAdvice, validation + malformed-JSON handling (doc 4)
├── controller/
│   ├── HelloController.java         # GET /hello (doc 2)
│   ├── CountryController.java       # GET/POST /countries, GET /countries/{code} (doc 2 & 4)
│   ├── EmployeeController.java      # GET/PUT /employees, DELETE /employees/{id} (doc 3 & 4)
│   ├── DepartmentController.java    # GET /departments (doc 3)
│   └── AuthenticationController.java# GET /authenticate → returns JWT (doc 5)
├── service/
│   ├── CountryService.java
│   ├── EmployeeService.java
│   ├── DepartmentService.java
│   └── exception/
│       ├── CountryNotFoundException.java
│       └── EmployeeNotFoundException.java
├── dao/
│   ├── CountryDao.java
│   ├── EmployeeDao.java
│   └── DepartmentDao.java
├── model/
│   ├── Country.java, Employee.java, Department.java, Skill.java
└── security/
    ├── SecurityConfig.java          # roles, BCrypt, wires JwtAuthorizationFilter
    └── JwtAuthorizationFilter.java  # validates "Bearer <jwt>" on every request

src/main/resources/
├── application.properties           # server.port=8090, logging pattern (doc 1 / doc 3)
├── date-format.xml                  # SimpleDateFormat bean (doc 1, hands on 2)
├── country.xml                      # single "country" bean + "countryList" (doc 1, hands on 4 & 6)
└── employee.xml                     # departments, skills, 4 employees (doc 3)

src/test/java/.../SpringLearnApplicationTests.java   # MockMVC tests (doc 2)
```

## Run

```
mvn clean package
mvn spring-boot:run
```

App starts on **port 8090** (`application.properties`). If you need proxy settings for `mvn`, add
`-Dhttp.proxyHost=... -Dhttp.proxyPort=... -Dhttps.proxyHost=... -Dhttps.proxyPort=...`
as the original hands-on docs describe.

## Try it (matches the curl commands in the docs)

Everything except `/hello` and `/authenticate` requires Spring Security's `user`/`pwd`
(role USER) or `admin`/`pwd` (role ADMIN) once `SecurityConfig` is active — same as doc 5.

```bash
# Hello world (doc 2) — not secured
curl -s http://localhost:8090/hello

# All countries — needs role USER
curl -s -u user:pwd http://localhost:8090/countries

# Single country, case-insensitive code
curl -s -u user:pwd http://localhost:8090/countries/in

# Not-found case (doc 2)
curl -i -u user:pwd http://localhost:8090/countries/az

# Create a country, with @Valid triggering GlobalExceptionHandler on bad input (doc 4)
curl -i -u user:pwd -H 'Content-Type: application/json' -X POST \
  -d '{"code":"IN","name":"India"}' http://localhost:8090/countries
curl -i -u user:pwd -H 'Content-Type: application/json' -X POST \
  -d '{"code":"I","name":"India"}'  http://localhost:8090/countries   # 400, validation error

# Employees / Departments (doc 3)
curl -s -u user:pwd http://localhost:8090/employees
curl -s -u user:pwd http://localhost:8090/departments

# Update / delete employee (doc 4)
curl -i -u user:pwd -H 'Content-Type: application/json' -X PUT \
  -d '{"id":1,"name":"John Smith","salary":60000,"permanent":true,"dateOfBirth":"14/05/1990",
       "department":{"id":1,"name":"Engineering"},"skills":[{"id":1,"name":"Java"}]}' \
  http://localhost:8090/employees
curl -i -u user:pwd -X DELETE http://localhost:8090/employees/4

# JWT flow (doc 5)
curl -s -u user:pwd http://localhost:8090/authenticate
# -> {"token":"eyJ..."}
curl -s -H "Authorization: Bearer <paste token here>" http://localhost:8090/countries
curl -i -H "Authorization: Bearer wrong.token.here" http://localhost:8090/countries   # 401 / falls through auth
```

## Tests

```
mvn clean test
```

`SpringLearnApplicationTests`:
- `contextLoads()` — asserts `CountryController` is autowired
- `getCountry()` — MockMVC GET `/countries/IN`, asserts 200 + `code`/`name` in body
- `testGetCountryException()` — MockMVC GET on an unknown code, asserts the 404 + reason from
  `CountryNotFoundException`'s `@ResponseStatus`

## Notes on choices made

- `CountryController` reflects the **end state** after doc 4's refactor (class-level
  `@RequestMapping("/countries")`, `@GetMapping`/`@PostMapping`) rather than the original
  `/country` + `@RequestMapping` version from doc 2 — the docs explicitly ask you to migrate to
  this convention, so only the final version is implemented.
- JWT secret (`"secretkey"`) and expiry (20 minutes) are hard-coded exactly as specified in the
  doc — fine for a learning exercise, not for production.
- `employee.xml` parses `dateOfBirth` strings (`dd/MM/yyyy`) into `java.util.Date` via a
  `SimpleDateFormat` factory-bean/factory-method, since plain Spring XML has no built-in
  string→Date editor.
