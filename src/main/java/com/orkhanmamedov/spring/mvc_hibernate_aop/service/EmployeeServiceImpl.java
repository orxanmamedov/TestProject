package com.orkhanmamedov.spring.mvc_hibernate_aop.service;

import com.orkhanmamedov.spring.mvc_hibernate_aop.dao.EmployeeDAO;
import com.orkhanmamedov.spring.mvc_hibernate_aop.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeDAO dao;
    @Autowired
    public void setDao(EmployeeDAO dao){
        this.dao = dao;
    }
    @Override
    @Transactional
    public List<Employee> getListOfEmployees() {
       return dao.getListOfEmployees();
    }

    @Override
    @Transactional
    public void saveEmployee(Employee employee) {
        dao.saveEmployee(employee);
    }

    @Override
    @Transactional
    public Employee getEmployeeById(int id) {
        return dao.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        dao.deleteEmployee(id);

    }
}
