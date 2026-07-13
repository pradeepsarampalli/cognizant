package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.exception.EmployeeNotFoundException;

@Repository
public class EmployeeDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);

    @SuppressWarnings("unchecked")
    private static ArrayList<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        EMPLOYEE_LIST = (ArrayList<Employee>) context.getBean("employeeList", List.class);
        LOGGER.info("END");
    }

    public ArrayList<Employee> getAllEmployees() {
        LOGGER.info("START");
        LOGGER.debug("employees: {}", EMPLOYEE_LIST);
        LOGGER.info("END");
        return EMPLOYEE_LIST;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        LOGGER.info("START");
        for (int i = 0; i < EMPLOYEE_LIST.size(); i++) {
            if (EMPLOYEE_LIST.get(i).getId().equals(employee.getId())) {
                EMPLOYEE_LIST.set(i, employee);
                LOGGER.info("END");
                return;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public void deleteEmployee(Long id) throws EmployeeNotFoundException {
        LOGGER.info("START");
        boolean removed = EMPLOYEE_LIST.removeIf(employee -> employee.getId().equals(id));
        if (!removed) {
            throw new EmployeeNotFoundException();
        }
        LOGGER.info("END");
    }
}
