package com.company.service.impl;

import com.company.exception.ResourceNotFoundException;
import com.company.model.Employee;
import com.company.repository.EmployeeRepository;
import com.company.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee create(Employee employee) {
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee update(Integer id, Employee employeeUpdate) {
        Employee employee = findById(id);
        employee.setName(employeeUpdate.getName());
        employee.setCpf(employeeUpdate.getCpf());
        employee.setPhone(employeeUpdate.getPhone());
        employee.setEmail(employeeUpdate.getEmail());
        employee.setSalary(employeeUpdate.getSalary());
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Funcionário com ID " + id + " não encontrado."));
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        Employee employee = findById(id);
        employeeRepository.deleteById(employee.getId());
    }
}
