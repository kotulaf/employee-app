package com.demoApp.employeemanager.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name="employee_table")
@Table(name="employee_table")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Employee implements Serializable {
    @Id
    @SequenceGenerator(name = "employee_sequence", sequenceName = "employee_sequence" , allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "employee_sequence")
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "job_title")
    private String jobTitle;

    @Column(name = "phone")
    private String phone;

    @Column(name = "imageUrl")
    private String imageUrl;
    
    @Column(name = "employeeCode", nullable = false, updatable = false)
    private String employeeCode;
}
