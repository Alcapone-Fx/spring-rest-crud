package com.restapi.employeesdirectory.dao;

import com.restapi.employeesdirectory.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    void deleteById(int id);
}
