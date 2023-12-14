package com.restapi.employeesdirectory.rest;

import com.restapi.employeesdirectory.dao.EmployeeDAO;
import com.restapi.employeesdirectory.entity.Employee;
import com.restapi.employeesdirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return this.employeeService.findAll();
    }
}
