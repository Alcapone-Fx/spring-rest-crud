package com.restapi.employeesdirectory.service;

import com.restapi.employeesdirectory.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
