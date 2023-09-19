package com.dev.employeemanager.service.impl;

import com.dev.employeemanager.entity.Employee;
import com.dev.employeemanager.repository.EmployeeRepo;
import com.dev.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeRepo employeeRepo;

    @Override
    public void addEmployee(Employee emp) {
        this.employeeRepo.save(emp);
    }

    @Override
    public List<Employee> getAllEmployees() {
        List<Employee> employees = this.employeeRepo.findAll();
        return employees;
    }

    @Override
    public Employee getEmployeeById(Integer id) {
        Employee emp = this.employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Resource Not Found!"));
        return emp;
    }

    @Override
    public void updateEmployee(Integer id, Employee emp) {

        Employee employee = this.employeeRepo.findById(id).orElseThrow(()->new RuntimeException("Resource Not Found!"));
        employee.setDepartment(emp.getDepartment());
        employee.setEmail(emp.getEmail());
        employee.setPassword(emp.getPassword());
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());
        this.employeeRepo.save(emp);
    }

    @Override
    public void deleteEmployee(Integer id) {
        Employee emp = this.employeeRepo.findById(id).orElseThrow(() -> new RuntimeException("Resource Not Found!"));
        this.employeeRepo.delete(emp);
    }
}
