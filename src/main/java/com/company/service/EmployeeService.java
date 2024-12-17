package com.company.service;

import com.company.model.Employee;
import com.company.repository.EmployeeRepository;

import java.util.List;

public interface EmployeeService {

    Employee create(Employee employee);

    Employee update(Integer id, Employee employeeUpdate);

    Employee findById(Integer id);

    List<Employee> findAll();

    void delete(Integer id);
}
