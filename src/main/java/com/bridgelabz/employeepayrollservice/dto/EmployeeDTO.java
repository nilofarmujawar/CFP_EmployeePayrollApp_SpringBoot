package com.bridgelabz.employeepayrollservice.dto;

/**
 * import class
 */
import java.time.LocalDate;

/**
 * create a class name as EmployeeDTO
 */
public class EmployeeDTO {
    /**
     * private variables can only be accessed within the same class (an outside class has no access to it)
     * private = restricted access
     * However, it is possible to access them if we provide public get and set methods.
     */

    //variables
    private String firstName;
    private String lastName;
    private String profilePic;
    private String department;
    private Long salary;
    private LocalDate date;
    private String notes;

    /**
     * create default constructor
     */
    public EmployeeDTO() {
        super();
    }

    /**
     * create a parameterized constructor
     * @param firstName - employee first name
     * @param lastName - employee last name
     * @param profilePic - employee profile pic
     * @param department - employee working department
     * @param salary - employee salary
     * @param date - date
     * @param notes - any notes
     */
    public EmployeeDTO(String firstName, String lastName, String profilePic, String department, Long salary,
                       LocalDate date, String notes) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePic = profilePic;
        this.department = department;
        this.salary = salary;
        this.date = date;
        this.notes = notes;
    }

    /**
     * Used getter and setter to set and get the value.
     * Setter is used to set the value
     * Getter is used to get the value
     */

    /**
     * crete a get method name as getFirstName
     * The get method returns the value of the variable
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * crete a get method name as getLastName
     * The get method returns the value of the variable
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * crete a get method name as getProfilePic
     * The get method returns the value of the variable
     * @return profilePic
     */
    public String getProfilePic() {
        return profilePic;
    }

    /**
     * crete a get method name as getDepartment
     * The get method returns the value of the variable
     * @return department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * crete a get method name as getSalary
     * The get method returns the value of the variable
     * @return salary
     */
    public Long getSalary() {
        return salary;
    }

    /**
     * crete a get method name as getDate
     * The get method returns the value of the variable
     * @return data
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * crete a get method name as getNotes
     * The get method returns the value of the variable
     * @return notes
     */
    public String getNotes() {
        return notes;
    }

}