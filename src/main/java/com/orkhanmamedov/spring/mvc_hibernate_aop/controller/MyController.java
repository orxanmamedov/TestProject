package com.orkhanmamedov.spring.mvc_hibernate_aop.controller;


import com.orkhanmamedov.spring.mvc_hibernate_aop.entity.Employee;


import com.orkhanmamedov.spring.mvc_hibernate_aop.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@org.springframework.stereotype.Controller

public class MyController {

    private EmployeeService employeeService;
    @Autowired
    private void setEmployeeService(EmployeeService employeeService){
        this.employeeService = employeeService;
    }



    @RequestMapping("/")
    private String showAllEmployees(Model model){

        List<Employee> employeesList = employeeService.getListOfEmployees();
        model.addAttribute("employeesList", employeesList);

        return "show-all-employees";
    }

    @RequestMapping("/addNewEmployee")
    private String addNewEmployee(Model model){

        Employee employee = new Employee();
        model.addAttribute("employee", employee);

        return "info-employee";
    }

    @RequestMapping("/saveEmployee")
    private String saveEmployee(@ModelAttribute("employee") Employee employee){

        employeeService.saveEmployee(employee);

        return "redirect:/";
    }

    @RequestMapping("/updateEmployee")
    private String updateEmployee(@RequestParam("empId") int id, Model model){

        Employee employee = employeeService.getEmployeeById(id);
        model.addAttribute("employee", employee);

        return "info-employee";
    }

    @RequestMapping("/deleteEmployee")
    private String deleteEmployee(@RequestParam("empId") int id){

        employeeService.deleteEmployee(id);

        return "redirect:/";
    }
}
