package com.bridgelabz.employeepayrollservice.controller;

/**
 * import classes
 */

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

/**
 *  1) @RestController :-
 *           @RestController is used for making restful web services with the help of the @RestController annotation.
 *           This annotation is used at the class level and allows the class to handle the requests made by the client
 *
 */
@RestController
/**
 * create a class name as EmployeePayrollController
 */
public class EmployeePayrollController {
    /**
     * 2) @AutoMapping :-
     *          @Autowiring feature of spring framework enables you to inject the object dependency implicitly.
     *          It internally uses setter or constructor injection.
     *          Autowiring can't be used to inject primitive and string values.
     */
    @Autowired
    IEmployeePayrollService service;


    /**
     * 3) @GetMapping :-
     *           @GetMapping annotation maps HTTP GET requests onto specific handler methods.
     *           It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. GET)
     *
     * Ability to display welcome message
     * @return :- welcome msg
     */
    @GetMapping("/employeePayrollService")
    public ResponseEntity<String> getWelcome() {
        return new ResponseEntity<String>(service.getWelcome(), HttpStatus.OK);
    }

    /**
     * 4) @PostMapping :-
     *           @PostMapping annotation maps HTTP POST requests onto specific handler methods.
     *           It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. POST)
     *
     * 5) @RequestBody :-
     *            @RequestBody annotation is applicable to handler methods of Spring controllers.
     *            This annotation indicates that Spring should deserialize a request body into an object.
     *            This object is passed as a handler method parameter
     *
     * Ability to save employee details to repository
     * @apiNote- accepts the employee data in JSON format and stores it in DB
     * @param employee - employee data
     * @return :- newemployee data
     */
    @PostMapping("/employeePayrollService/create")
    public ResponseEntity<Employee> saveDataToRepo(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<Employee>(service.postDataToRepo(employee), HttpStatus.OK);
    }

    /**
     * Ability to get all employees' data by findAll() method
     * @return :- showing all data
     */
    @GetMapping("/employeePayrollService/get")
    public ResponseEntity<List<Employee>> getAllDataFromRepo() {
        return new ResponseEntity<List<Employee>>(service.getAllData(), HttpStatus.OK);
    }

    /**
     * 6) @PathVariable :-
     *           @PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable. It has the following optional elements: name - name of the path variable to bind to.
     *           required - tells whether the path variable is required.

     * Ability to get employee data by id
     * @param id - employee id
     * @return -employee information with same empId in JSON format
     */
    @GetMapping("/employeePayrollService/get/{id}")
    public ResponseEntity<Employee> getDataFromRepoById(@PathVariable Integer id) {
        Optional<Employee> employee = service.getDataById(id);
        ResponseDTO dto = new ResponseDTO("Data",employee);
        return new ResponseEntity(dto, HttpStatus.OK);
    }

    /**
     * 7) @PutMapping :-
     *            @PutMapping Annotation for mapping HTTP PUT requests onto specific handler methods.
     *            Specifically, @PutMapping is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod.PUT).
     *
     * Ability to update employee data for particular id
     * @apiNote - accepts the employee data in JSON format and updates the employee having same empId from database
     * @param id - employee id
     * @param employeeDTO -  represents object of EmployeeDTO class
     * @return - updated employee information in JSON format
     */
    @PutMapping("/employeePayrollService/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id, @RequestBody EmployeeDTO employeeDTO) {
        Employee employee = service.updateDataById(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Updating Employee PayrollData Successfuly:", employee);
        return new ResponseEntity(employeeDTO, HttpStatus.OK);
    }

    /**
     * Ability to delete employee data for particular id
     * @apiNote - accepts the empId and deletes the data of that employee from DB
     * @param id - represents employee id
     * @return -  empId and Acknowledgment message
     */
    @DeleteMapping("/employeePayrollService/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) {
        return new ResponseEntity<String>(service.deleteDataById(id), HttpStatus.OK);
    }
}
