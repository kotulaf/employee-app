package com.demoApp.employeemanager.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class Employee {
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
}
