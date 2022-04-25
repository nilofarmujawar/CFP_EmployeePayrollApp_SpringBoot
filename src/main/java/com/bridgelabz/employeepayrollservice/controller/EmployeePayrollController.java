package com.bridgelabz.employeepayrollservice.controller;

import com.bridgelabz.employeepayrollservice.dto.EmployeeDTO;
import com.bridgelabz.employeepayrollservice.dto.ResponseDTO;
import com.bridgelabz.employeepayrollservice.exception.EmployeePayrollException;
import com.bridgelabz.employeepayrollservice.model.Employee;
import com.bridgelabz.employeepayrollservice.service.IEmployeePayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

 /**
  *  1) @RestController :-
  *           @RestController is used for making restful web services with the help of the @RestController annotation.
  *           This annotation is used at the class level and allows the class to handle the requests made by the client
  * 2) @RequestMapping :-
  *           @RequestMapping used to map web requests onto specific handler classes and/or handler methods.
  *           RequestMapping can be applied to the controller class as well as methods
  *
  * - Created controller so that we can perform rest api calls
  */


@RestController
@RequestMapping("/employeepayrollservice")

// create a class name as EmployeePayrollController
public class EmployeePayrollController {

     /**
      * 3) @AutoMapping :-
      *          @Autowiring feature of spring framework enables you to inject the object dependency implicitly.
      *          It internally uses setter or constructor injection.
      *
      * - Autowired IEmployeePayrollService interface so we can inject its dependency here
      */

    @Autowired
    IEmployeePayrollService service;

     /**
      * 4) @GetMapping :-
      *           @GetMapping annotation maps HTTP GET requests onto specific handler methods.
      *           It is a composed annotation that acts as a shortcut for @RequestMapping(method = RequestMethod. GET)
      *
      * - Ability to display welcome message
      * @return :- welcome msg
      */
    @GetMapping("/welcome")
    public ResponseEntity<String> getWelcome() {
        String welcome = service.getWelcome();
        return new ResponseEntity<String>(welcome, HttpStatus.OK);
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
      * - Ability to save employee details to repository
      * @apiNote- accepts the employee data in JSON format and stores it in DB
      * @param employeeDTO - employee data
      * @return :- newemployee data
      */
    @PostMapping("/create")
    public ResponseEntity<String> addDataToRepo(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Employee newEmployee = service.postDataToRepo(employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Record Added Succesfully", newEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.CREATED);
    }

     /**
      * - Ability to get all employees' data by findAll() method
      * @return :- showing all data
      */
    @GetMapping("/get")
    public ResponseEntity<String> getAllDataFromRepo() {
        List<Employee> listOfEmployee = service.getAllData();
        ResponseDTO responseDTO = new ResponseDTO("Record Retrieved Successfully", listOfEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
    }

     /**
      * 6) @PathVariable :-
      *           @PathVariable is a Spring annotation which indicates that a method parameter should be bound to a URI template variable. It has the following optional elements: name - name of the path variable to bind to.
      *           required - tells whether the path variable is required.
      * - Ability to get employee data by id
      * @param id - employee id
      * @return -employee information with same empId in JSON format
      */
    @GetMapping("/get/{id}")
    public ResponseEntity<String> getDataFromRepoById(@PathVariable Integer id) throws EmployeePayrollException {
        Employee existingEmployee = service.getDataById(id);
        ResponseDTO responseDTO = new ResponseDTO("Record for given ID Retrieved Successfully", existingEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.OK);
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
    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateDataInRepo(@PathVariable Integer id,
                                                   @Valid @RequestBody EmployeeDTO employeeDTO)
            throws EmployeePayrollException {
        Employee updatedEmployee = service.updateDataById(id, employeeDTO);
        ResponseDTO responseDTO = new ResponseDTO("Record for particular ID Updated Successfully", updatedEmployee);
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }

     /**
      * - Ability to delete employee data for particular id
      * @apiNote - accepts the empId and deletes the data of that employee from DB
      * @param id - represents employee id
      * @return -  empId and Acknowledgment message
      */
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteDataInRepo(@PathVariable Integer id) throws EmployeePayrollException {
        ResponseDTO responseDTO = new ResponseDTO
                ("Record for particular ID Deleted Successfully", service.deleteDataById(id));
        return new ResponseEntity(responseDTO, HttpStatus.ACCEPTED);
    }
}