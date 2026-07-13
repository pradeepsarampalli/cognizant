package com.cognizant.springlearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;

@Repository
public class DepartmentDao {

    private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);

    @SuppressWarnings("unchecked")
    private static ArrayList<Department> DEPARTMENT_LIST;

    public DepartmentDao() {
        LOGGER.info("START");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        DEPARTMENT_LIST = (ArrayList<Department>) context.getBean("departmentList", List.class);
        LOGGER.info("END");
    }

    public ArrayList<Department> getAllDepartments() {
        LOGGER.info("START");
        LOGGER.debug("departments: {}", DEPARTMENT_LIST);
        LOGGER.info("END");
        return DEPARTMENT_LIST;
    }
}
