package com.bridgelabz.employeepayrollservice.controller;


import com.bridgelabz.employeepayrollservice.model.Employee;
import com.bridgelabz.employeepayrollservice.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EmployeePayrollController {
    @Autowired
    IEmployeePayrollService service;

    @GetMapping("/getMessage")
    public ResponseEntity<String> getMessage(@RequestParam String name) {
        return new ResponseEntity<String>(service.getMessage(name), HttpStatus.OK);
    }

    @PostMapping("/postMessage")
    public ResponseEntity<Employee> postMessage(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(service.postMessage(employee), HttpStatus.OK);
    }

    //ability to display welcome message
    @GetMapping("/employeePayrollService")
    public ResponseEntity<String> getWelcome() {
        return new ResponseEntity<String>(service.getWelcome(), HttpStatus.OK);
    }

    //ability to save employee details to repository
    @PostMapping("/employeePayrollService/create")
    public ResponseEntity<Employee> saveDataToRepo(@RequestBody Employee employee) {
        return new ResponseEntity<Employee>(service.postDataToRepo(employee), HttpStatus.OK);
    }

    //ability to get all employees' data by findAll() method
    @GetMapping("/employeePayrollService/get")
    public ResponseEntity<List<Employee>> getAllDataFromRepo() {
        return new ResponseEntity<List<Employee>>(service.getAllData(), HttpStatus.OK);
    }

    //ability to get employee data by id
    @GetMapping("/employeePayrollService/get/{id}")
    public ResponseEntity<Optional<Employee>> getDataFromRepoById(@PathVariable Integer id) {
        return new ResponseEntity<Optional<Employee>>(service.getDataById(id), HttpStatus.OK);
    }

    //ability to update employee data for particular id
    @PutMapping("/employeePayrollService/update/{id}")
    public ResponseEntity<Employee> updateDataInRepo(@PathVariable Integer id, @RequestBody Employee employee) {
        return new ResponseEntity<Employee>(service.updateDataById(id, employee), HttpStatus.OK);
    }

    //ability to delete employee data for particular id
    @DeleteMapping("/employeePayrollService/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) {
        return new ResponseEntity<String>(service.deleteDataById(id), HttpStatus.OK);
    }
}