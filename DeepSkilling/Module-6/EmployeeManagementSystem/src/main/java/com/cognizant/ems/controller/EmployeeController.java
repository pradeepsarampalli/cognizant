package com.cognizant.ems.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.ems.model.Employee;
import com.cognizant.ems.projection.EmployeeNameOnly;
import com.cognizant.ems.projection.EmployeeSummary;
import com.cognizant.ems.repository.DepartmentRepository;
import com.cognizant.ems.repository.EmployeeRepository;

/**
 * Exercise 4 - CRUD operations.
 * Exercise 5 - Custom query methods (search).
 * Exercise 6 - Pagination and Sorting.
 * Exercise 8 - Projections.
 */
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    // ---------------------------------------------------------------
    // Exercise 4 - Basic CRUD
    // ---------------------------------------------------------------
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable Long id) {
        return employeeRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee saved = employeeRepository.save(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee update) {
        return employeeRepository.findById(id)
                .map(existing -> {
                    existing.setName(update.getName());
                    existing.setEmail(update.getEmail());
                    existing.setDepartment(update.getDepartment());
                    return ResponseEntity.ok(employeeRepository.save(existing));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!employeeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // ---------------------------------------------------------------
    // Exercise 5 - Query Methods / search
    // ---------------------------------------------------------------
    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) {
        return employeeRepository.findByNameContainingIgnoreCase(name);
    }

    @GetMapping("/by-department-name")
    public List<Employee> byDepartmentName(@RequestParam String name) {
        return employeeRepository.findByDepartmentName(name);
    }

    // ---------------------------------------------------------------
    // Exercise 6 - Pagination and Sorting
    //   GET /api/employees?page=0&size=5&sortBy=name&direction=asc
    // ---------------------------------------------------------------
    @GetMapping
    public Page<Employee> getAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "asc") String direction) {

        Sort sort = direction.equalsIgnoreCase("desc") ? Sort.by(sortBy).descending() : Sort.by(sortBy).ascending();
        Pageable pageable = PageRequest.of(page, size, sort);
        return employeeRepository.findAll(pageable);
    }

    @GetMapping("/department/{departmentId}")
    public Page<Employee> getByDepartmentPaged(
            @PathVariable Long departmentId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return employeeRepository.findByDepartmentId(departmentId, PageRequest.of(page, size));
    }

    // ---------------------------------------------------------------
    // Exercise 8 - Projections
    // ---------------------------------------------------------------
    @GetMapping("/department/{departmentId}/summary")
    public List<EmployeeSummary> getSummaryByDepartment(@PathVariable Long departmentId) {
        return employeeRepository.findByDepartment_Id(departmentId);
    }

    @GetMapping("/names-only")
    public List<EmployeeNameOnly> getAllNamesOnly() {
        return employeeRepository.findAllNamesOnly();
    }
}
