package com.demoApp.employeemanager.repo;

import com.demoApp.employeemanager.model.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
    
}
