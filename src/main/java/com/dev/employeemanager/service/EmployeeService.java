package com.dev.employeemanager.service;

import com.dev.employeemanager.entity.Employee;

import java.util.List;

public interface EmployeeService {

    //create an Employee
    void addEmployee(Employee emp);

    //Get All Employees
    List<Employee> getAllEmployees();

    //Get Single Employee By id
    Employee getEmployeeById(Integer id);

    //Update An Employee
    void updateEmployee(Integer id, Employee employee);
    //Delete an Employee by Id
    void deleteEmployee(Integer id);
}
