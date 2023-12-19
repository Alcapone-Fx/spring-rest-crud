package com.restapi.employeesdirectory.dao;

import com.restapi.employeesdirectory.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOJPAImpl implements EmployeeDAO{

    private EntityManager entityManager;
    public EmployeeDAOJPAImpl() {
    }

    @Autowired
    public EmployeeDAOJPAImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        // "from Employee" this should point to the Entity
        TypedQuery<Employee> query = this.entityManager.createQuery("from Employee", Employee.class);
        return query.getResultList();
    }

    @Override
    public Employee findById(int id) {
        return this.entityManager.find(Employee.class, id);
    }

    @Override
    public Employee save(Employee employee) {
        return this.entityManager.merge(employee);
    }

    @Override
    public void deleteById(int id) {
        Employee employee = this.findById(id);
        this.entityManager.remove(employee);
    }
}
