package com.demoApp.employeemanager.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demoApp.employeemanager.exception.UserNotFoundException;
import com.demoApp.employeemanager.model.Employee;
import com.demoApp.employeemanager.repo.EmployeeRepo;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    
    @Autowired
    public EmployeeService(EmployeeRepo employeeRepo)
    {
        this.employeeRepo = employeeRepo;
    }

    public Employee addEmployee(Employee employee)
    {
        employee.setEmployeeCode(UUID.randomUUID().toString());

        return employeeRepo.save(employee);
    }

    public List<Employee> findAllEmployees()
    {
        return employeeRepo.findAll();
    }

    public Employee updateEmployee(Employee employee)
    {
        return employeeRepo.save(employee);
    }

    public void deleteEmployee(Long id)
    {
        employeeRepo.deleteById(id);
    }

    public Employee findEmployeeById(Long id)
    {
        return employeeRepo.findEmployeeById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " not found"));
    }

    /* 

    public void deleteEmployee(Employee employee)
    {
        employeeRepo.deleteEmployeeById(employee.getId());
    }

    */
}
