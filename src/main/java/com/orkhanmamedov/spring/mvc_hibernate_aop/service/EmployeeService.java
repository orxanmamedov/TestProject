package com.orkhanmamedov.spring.mvc_hibernate_aop.service;

import com.orkhanmamedov.spring.mvc_hibernate_aop.entity.Employee;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getListOfEmployees();
    public void saveEmployee(Employee employee);
    public Employee getEmployeeById(int id);
    void deleteEmployee(int id);
}
