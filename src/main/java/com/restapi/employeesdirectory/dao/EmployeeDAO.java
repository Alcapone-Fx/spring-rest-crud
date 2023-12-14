package com.restapi.employeesdirectory.dao;

import com.restapi.employeesdirectory.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
