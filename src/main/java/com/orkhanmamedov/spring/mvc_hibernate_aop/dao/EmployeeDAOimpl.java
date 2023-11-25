package com.orkhanmamedov.spring.mvc_hibernate_aop.dao;

import com.orkhanmamedov.spring.mvc_hibernate_aop.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class EmployeeDAOimpl implements EmployeeDAO {

    private SessionFactory sessionFactory;
    @Autowired
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    @Override

    public List<Employee> getListOfEmployees() {
        Session session = sessionFactory.getCurrentSession();

//        session.beginTransaction();

        List<Employee> employees = session.createQuery("from Employee ").getResultList();

//        session.getTransaction().commit();
        return employees;
    }

    @Override

    public void saveEmployee(Employee employee) {
        Session session = sessionFactory.getCurrentSession();

        session.saveOrUpdate(employee);
    }

    @Override
    public Employee getEmployeeById(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Employee.class, id);
    }

    @Override
    public void deleteEmployee(int id) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(session.get(Employee.class, id));
    }
}
