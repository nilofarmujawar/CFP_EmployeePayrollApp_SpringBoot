package com.bridgelabz.employeepayrollservice.service;

import com.bridgelabz.employeepayrollservice.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollservice.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollservice.model.Employee;
import com.bridgelabz.employeepayrollservice.repository.EmployeePayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service

/**
 * Created EmployeePayrollService class to serve api calls done by controller layer
 */
public class EmployeePayrollService implements IEmployeePayrollService {

    /**
     * Autowired EmployeePayrollRepository interface to inject its dependency here
     */
    @Autowired
    EmployeePayrollRepository repository;

    /**
     * create a method name as getWelcome
     * @return :- welcome msg
     */
    public String getWelcome() {

        return "Welcome to Employee Payroll !!!";
    }

    /**
     * create a method name as postDataToRepo
     * Ability to save employee details to repository
     * @param employeeDTO
     * @return
     */
    public Employee postDataToRepo(EmployeeDTO employeeDTO) {
        Employee newEmployee = new Employee(employeeDTO);
        repository.save(newEmployee);
        return newEmployee;
    }

    /**
     * create a method name as getAllData
     * - Ability to get all employees' data by findAll() method
     * @return - all data
     */
    public List<Employee> getAllData() {
        List<Employee> list = repository.findAll();
        return list;
    }

    /**
     * create a method name as getDataById
     * - Ability to get employee data by id
     * @param id - employee id
     * @return - employee data by id
     */
    public Employee getDataById(Integer id) {
        Optional<Employee> newEmployee = repository.findById(id);
        if (newEmployee.isPresent()) {
            return newEmployee.get();
        } else throw new EmployeePayrollException("Employee id not found");
    }

    /**
     * create a method name as updateDataById
     * Ability to update employee data for particular id
     * @param id - employee id
     * @param employeeDTO - employee data
     * @return - updated employee information in JSON format
     */
    public Employee updateDataById(Integer id, EmployeeDTO employeeDTO) {
        Optional<Employee> newEmployee = repository.findById(id);
        if (newEmployee.isPresent()) {
            Employee employee = new Employee(id, employeeDTO);
            repository.save(employee);
            return employee;
        } else {
            throw new EmployeePayrollException("Employee Not found");
        }
    }

    /**
     * create a method name as deleteDataBYId
     * abiliy to delete data by particular employee id
     * @param id - employee id
     * @return - empId and Acknowledgment message
     */
    public String deleteDataById(Integer id) {
        Optional<Employee> newEmployee = repository.findById(id);
        if (newEmployee.isPresent()) {
            repository.deleteById(id);
        } else {
            throw new EmployeePayrollException("Employee Details not found");
        }
        return null;
    }

    /**
     * create a method name as getDataByDepartment
     * Abilty to serve controller class api to retrieve data having particular department
     * @param department - employee department
     * @return - get employee data by there department
     */
    public List<Employee> getDataByDepartment(String department) {
        List<Employee> newEmp = repository.findByDepartment(department);
        if (newEmp.isEmpty()) {
            throw new EmployeePayrollException("Employee Not Found");
        }
        return newEmp;
    }

}