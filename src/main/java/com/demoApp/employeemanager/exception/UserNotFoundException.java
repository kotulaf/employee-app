package com.demoApp.employeemanager.exception;

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String error)
    {
        super(error);
    } 
}
