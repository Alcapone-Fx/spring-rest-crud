package com.restapi.employeesdirectory.rest;

import com.restapi.employeesdirectory.dao.EmployeeDAO;
import com.restapi.employeesdirectory.entity.Employee;
import com.restapi.employeesdirectory.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) {
        Employee employee = this.employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("Employee id not found - " + id);
        }

        return employee;
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable int id) {
        this.employeeService.deleteById(id);
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee employee) {
        employee.setId(0);
       return this.employeeService.save(employee);
    }

    @PutMapping("/employees")
    public Employee modifyEmployee(@RequestBody Employee employee) {
       return this.employeeService.save(employee);
    }
}
