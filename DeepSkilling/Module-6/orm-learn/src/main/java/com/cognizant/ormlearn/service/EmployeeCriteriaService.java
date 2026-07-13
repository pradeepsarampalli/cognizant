package com.cognizant.ormlearn.service;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.cognizant.ormlearn.model.Employee;

/**
 * Hands on 6 - Criteria Query.
 *
 * Demonstrates the "Amazon style filter" scenario from the hands-on:
 * a where clause that is built up dynamically depending on which
 * criteria the caller actually supplies, instead of a single fixed HQL
 * string. Any combination of the parameters below may be null/omitted;
 * only the supplied ones are added as predicates.
 */
@Service
public class EmployeeCriteriaService {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> search(Boolean permanent, Double minSalary, Double maxSalary, Integer departmentId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);
        Root<Employee> employee = cq.from(Employee.class);

        List<Predicate> predicates = new ArrayList<>();

        if (permanent != null) {
            predicates.add(cb.equal(employee.get("permanent"), permanent));
        }
        if (minSalary != null) {
            predicates.add(cb.greaterThanOrEqualTo(employee.get("salary"), minSalary));
        }
        if (maxSalary != null) {
            predicates.add(cb.lessThanOrEqualTo(employee.get("salary"), maxSalary));
        }
        if (departmentId != null) {
            predicates.add(cb.equal(employee.get("department").get("id"), departmentId));
        }

        cq.select(employee).where(cb.and(predicates.toArray(new Predicate[0])));

        return entityManager.createQuery(cq).getResultList();
    }
}
