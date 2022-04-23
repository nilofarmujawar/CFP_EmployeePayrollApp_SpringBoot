package com.bridgelabz.employeepayrollservice.controller;


import com.bridgelabz.employeepayrollservice.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollservice.dto.ResponseDTO;
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


    //Ability to display welcome message
    @GetMapping("/employeePayrollService")
    public ResponseEntity<String> getWelcome() {
        return new ResponseEntity<String>(service.getWelcome(), HttpStatus.OK);
    }

    //Ability to save employee details to repository
    @PostMapping("/employeePayrollService/create")
    public ResponseEntity<Employee> saveDataToRepo(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<Employee>(service.postDataToRepo(employee), HttpStatus.OK);
    }

    //Ability to get all employees' data by findAll() method
    @GetMapping("/employeePayrollService/get")
    public ResponseEntity<List<Employee>> getAllDataFromRepo() {
        return new ResponseEntity<List<Employee>>(service.getAllData(), HttpStatus.OK);
    }

    //Ability to get employee data by id
    @GetMapping("/employeePayrollService/get/{id}")
    public ResponseEntity<Employee> getDataFromRepoById(@PathVariable Integer id) {
        Optional<Employee> employee = service.getDataById(id);
        ResponseDTO dto = new ResponseDTO("Data",employee);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    //Ability to update employee data for particular id
    @PutMapping("/employeePayrollService/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = service.updateDataById(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating Employee PayrollData Successfuly:", employee);
        return new ResponseEntity(employeeDTO, HttpStatus.OK);
    }

    //Ability to delete employee data for particular id
    @DeleteMapping("/employeePayrollService/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) {
        return new ResponseEntity<String>(service.deleteDataById(id), HttpStatus.OK);
    }
}