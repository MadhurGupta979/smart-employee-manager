package com.dev.employeemanager.controller;

import com.dev.employeemanager.entity.Employee;
import com.dev.employeemanager.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/all")
    public String getAllEmployees(Model model) {
        List<Employee> employeeList = this.employeeService.getAllEmployees();
        model.addAttribute("employees", employeeList);
        return "employee-views";
    }

    @GetMapping("/add")
    public String addEmployee(Model model){
        Employee employee = new Employee();
        model.addAttribute("emp", employee);
        return "add-form";
    }

    @GetMapping("/edit/{id}")
    public  String updateEmployee(@PathVariable("id") int id,  Model model){
        Employee employee = this.employeeService.getEmployeeById(id);
        model.addAttribute("emp", employee);
        model.addAttribute("id", id);
        return "update-form";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addEmployee(@ModelAttribute("emp") Employee employee, BindingResult theBindingResult){
        if(theBindingResult.hasErrors()){
            return "add-form";
        } else {
            this.employeeService.addEmployee(employee);
            return "redirect:/employees/all";
        }
    }

    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        this.employeeService.deleteEmployee(id);
        return "redirect:/employees/all";
    }





}
