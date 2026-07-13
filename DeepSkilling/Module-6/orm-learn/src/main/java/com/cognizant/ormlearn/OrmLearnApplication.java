package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeCriteriaService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;
import com.cognizant.ormlearn.service.exception.CountryNotFoundException;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static CountryService countryService;
    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;
    private static StockService stockService;
    private static EmployeeCriteriaService employeeCriteriaService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
        LOGGER.info("Inside main");

        countryService = context.getBean(CountryService.class);
        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);
        stockService = context.getBean(StockService.class);
        employeeCriteriaService = context.getBean(EmployeeCriteriaService.class);

        // -----------------------------------------------------------
        // Comment/uncomment individual test methods below as you work
        // through each hands-on, exactly as the original document
        // describes. They are all left enabled here so a single run
        // exercises every solution end-to-end against the seeded H2
        // in-memory data (see src/main/resources/data.sql).
        // -----------------------------------------------------------

        // Doc 1 - Hands on 1 / 5-9 : Country CRUD
        testGetAllCountries();
        testFindCountryByCode();
        testAddCountry();
        testUpdateCountry();
        testDeleteCountry();

        // Doc 2 - Hands on 1 : Query Methods on country
        testSearchCountriesContaining();
        testSearchCountriesContainingOrdered();
        testAlphabetIndexSearch();

        // Doc 2 - Hands on 2 : Query Methods on stock
        testGetFacebookStockSeptember2019();
        testGetGoogleStockAboveThreshold();
        testGetTop3HighestVolume();
        testGetTop3LowestNetflixClose();

        // Doc 2 - Hands on 4/5/6 : ManyToOne / OneToMany / ManyToMany
        testGetEmployee();
        testAddEmployee();
        testUpdateEmployee();
        testGetDepartment();
        testAddSkillToEmployee();

        // Doc 3 - Hands on 2/4/5 : HQL, aggregate functions, Native Query
        testGetAllPermanentEmployees();
        testGetAverageSalary();
        testGetAverageSalaryForDepartment();
        testGetAllEmployeesNative();

        // Doc 3 - Hands on 6 : Criteria Query
        testCriteriaSearch();

        LOGGER.info("Done");
    }

    // =================================================================
    // Doc 1 - Hands on 1: getAllCountries
    // =================================================================
    private static void testGetAllCountries() {
        LOGGER.info("Start");
        List<Country> countries = countryService.getAllCountries();
        LOGGER.debug("countries={}", countries);
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 1 - Hands on 6: find a country based on country code
    // =================================================================
    private static void testFindCountryByCode() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country:{}", country);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found", e);
        }
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 1 - Hands on 7: add a new country
    // =================================================================
    private static void testAddCountry() {
        LOGGER.info("Start");
        Country country = new Country("XX", "Testland");
        countryService.addCountry(country);
        try {
            Country added = countryService.findCountryByCode("XX");
            LOGGER.debug("Added Country:{}", added);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found", e);
        }
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 1 - Hands on 8: update a country based on code
    // =================================================================
    private static void testUpdateCountry() {
        LOGGER.info("Start");
        try {
            countryService.updateCountry("XX", "Testland Updated");
            Country updated = countryService.findCountryByCode("XX");
            LOGGER.debug("Updated Country:{}", updated);
        } catch (CountryNotFoundException e) {
            LOGGER.error("Country not found", e);
        }
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 1 - Hands on 9: delete a country based on code
    // =================================================================
    private static void testDeleteCountry() {
        LOGGER.info("Start");
        countryService.deleteCountry("XX");
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 2 - Hands on 1: search box - countries containing 'ou'
    // =================================================================
    private static void testSearchCountriesContaining() {
        LOGGER.info("Start");
        List<Country> countries = countryService.findCountriesContaining("ou");
        LOGGER.debug("Matching countries:{}", countries);
        LOGGER.info("End");
    }

    private static void testSearchCountriesContainingOrdered() {
        LOGGER.info("Start");
        List<Country> countries = countryService.findCountriesContainingOrderByName("ou");
        LOGGER.debug("Matching countries (ordered):{}", countries);
        LOGGER.info("End");
    }

    // Doc 2 - Hands on 1: alphabet index - countries starting with 'Z'
    private static void testAlphabetIndexSearch() {
        LOGGER.info("Start");
        List<Country> countries = countryService.findCountriesStartingWith("Z");
        LOGGER.debug("Countries starting with Z:{}", countries);
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 2 - Hands on 2: stock Query Methods
    // =================================================================
    private static void testGetFacebookStockSeptember2019() {
        LOGGER.info("Start");
        List<Stock> stocks = stockService.getStockForMonth("FB",
                LocalDate.of(2019, 9, 1), LocalDate.of(2019, 9, 30));
        LOGGER.debug("FB Sept 2019 stock:{}", stocks);
        LOGGER.info("End");
    }

    private static void testGetGoogleStockAboveThreshold() {
        LOGGER.info("Start");
        List<Stock> stocks = stockService.getStockAboveClose("GOOGL", new BigDecimal("1250"));
        LOGGER.debug("GOOGL stock above 1250:{}", stocks);
        LOGGER.info("End");
    }

    private static void testGetTop3HighestVolume() {
        LOGGER.info("Start");
        List<Stock> stocks = stockService.getTop3HighestVolume();
        LOGGER.debug("Top 3 highest volume:{}", stocks);
        LOGGER.info("End");
    }

    private static void testGetTop3LowestNetflixClose() {
        LOGGER.info("Start");
        List<Stock> stocks = stockService.getTop3LowestClose("NFLX");
        LOGGER.debug("Top 3 lowest NFLX close:{}", stocks);
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 2 - Hands on 4: ManyToOne between Employee and Department
    // =================================================================
    private static void testGetEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee:{}", employee);
        LOGGER.debug("Department:{}", employee.getDepartment());
        // Doc 2 - Hands on 6: also log the skill list once ManyToMany is wired up
        LOGGER.debug("Skills:{}", employee.getSkillList());
        LOGGER.info("End");
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");
        Employee employee = new Employee();
        employee.setName("New Hire");
        employee.setSalary(50000);
        employee.setPermanent(true);
        employee.setDateOfBirth(new Date());
        Department department = departmentService.get(1);
        employee.setDepartment(department);
        employeeService.save(employee);
        LOGGER.debug("Saved Employee:{}", employee);
        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(1);
        Department department = departmentService.get(2);
        employee.setDepartment(department);
        employeeService.save(employee);
        LOGGER.debug("Updated Employee:{}", employee);
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 2 - Hands on 5: OneToMany between Department and Employee
    // =================================================================
    private static void testGetDepartment() {
        LOGGER.info("Start");
        // pick a department id that has more than one employee (see data.sql)
        Department department = departmentService.get(1);
        LOGGER.debug("Department:{}", department);
        LOGGER.debug("Employees:{}", department.getEmployeeList());
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 2 - Hands on 6: ManyToMany between Employee and Skill
    // =================================================================
    private static void testAddSkillToEmployee() {
        LOGGER.info("Start");
        Employee employee = employeeService.get(2);
        Skill skill = skillService.get(3);
        employee.getSkillList().add(skill);
        employeeService.save(employee);
        LOGGER.debug("Employee with new skill:{}", employee);
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 3 - Hands on 2: get all permanent employees using HQL
    // =================================================================
    private static void testGetAllPermanentEmployees() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllPermanentEmployees();
        LOGGER.debug("Permanent Employees:{}", employees);
        employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 3 - Hands on 4: average salary using HQL aggregate function
    // =================================================================
    private static void testGetAverageSalary() {
        LOGGER.info("Start");
        double avg = employeeService.getAverageSalary();
        LOGGER.debug("Average salary (all departments):{}", avg);
        LOGGER.info("End");
    }

    private static void testGetAverageSalaryForDepartment() {
        LOGGER.info("Start");
        double avg = employeeService.getAverageSalary(1);
        LOGGER.debug("Average salary (department 1):{}", avg);
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 3 - Hands on 5: get all employees using Native Query
    // =================================================================
    private static void testGetAllEmployeesNative() {
        LOGGER.info("Start");
        List<Employee> employees = employeeService.getAllEmployeesNative();
        LOGGER.debug("All employees (native query):{}", employees);
        LOGGER.info("End");
    }

    // =================================================================
    // Doc 3 - Hands on 6: Criteria Query
    // =================================================================
    private static void testCriteriaSearch() {
        LOGGER.info("Start");
        // Equivalent to a user picking "permanent = true" and
        // "salary between 40000 and 100000" as filters on screen -
        // the where clause is built dynamically, only from the
        // criteria that are non-null.
        List<Employee> employees = employeeCriteriaService.search(true, 40000.0, 100000.0, null);
        LOGGER.debug("Criteria search result:{}", employees);
        LOGGER.info("End");
    }
}
