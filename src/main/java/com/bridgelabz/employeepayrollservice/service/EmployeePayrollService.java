package com.bridgelabz.employeepayrollservice.service;

import com.bridgelabz.employeepayrollservice.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollservice.model.Employee;
import com.bridgelabz.employeepayrollservice.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeePayrollService implements IEmployeePayrollService {
    @Autowired
    EmployeePayrollRepository repository;

    public String getMessage(String name) {
        return "Welcome To Employee Program " + name;
    }

    public String postMessage(EmployeeDTO employee) {
        return "Hello Employee " + employee.getFirstName() + "" + employee.getLastName() + "!";
    }

    public String putMessage(String name) {
        return "Hey Dude , " + name;
    }

    public String getWelcome() {
        return "Welcome to Employee Payroll App.....!";
    }

    @Override
    public Employee postDataToRepo(EmployeeDTO employee) {
        Employee newEmployee = new Employee(employee);
        repository.save(newEmployee);
        return newEmployee;
    }

    @Override
    public List<Employee> getAllData() {
        List<Employee> list = repository.findAll();
        return list;
    }

    @Override
    public Optional<Employee> getDataById(Integer id) {
        Optional<Employee> newEmployee = repository.findById(id);
        return newEmployee;
    }

    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(id, employeeDTO);
        repository.save(newEmployee);
        return newEmployee;
    }

    public String deleteDataById(Integer id) {
        repository.deleteById(id);
        return "Employee with unique ID:" + id + " got deleted";
    }


}