package com.bridgelabz.employeepayrollservice.dto;

import lombok.Data;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.util.List;

/**
 * - Created EmployeeDTO class and added validations to fields
 *
 * @Data :-
 *        Lombok Data annotation ( @Data ) Generates getters for all fields, a useful toString method,
 *        and hashCode and equals implementations that check all non-transient fields.
 *        Will also generate setters for all non-final fields, as well as a constructor.
 */
@Data
public class EmployeeDTO {
    /**
     * Regex validation pattern for firstName
     * [A-Z]{1} - Starting capital letter
     * [a-zA-Z]{2,} - other letter is 2 or more times
     */
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee firstName is Invalid")
    private String firstName;

    /**
     * Regex validation pattern for lastname
     * [A-Z]{1} - Starting capital letter
     * [a-zA-Z]{2,} - other letter is 2 or more times
     */
    @Pattern(regexp = "^[A-Z]{1}[a-zA-Z]{2,}$", message = "Employee lastName is Invalid")
    private String lastName;

    @NotEmpty(message = "ProfilePic cannot be null")
    private String profilePic;

    @NotEmpty(message = "Department name cannot be null")
    private List<String> department;

    @Pattern(regexp = "female|male ", message = "Gender needs to be male or female")
    private String gender;

    @Min(value = 500, message = "Salary should be more than 500")
    private Long salary;

    @PastOrPresent(message = "Date should be past or today date")
    private LocalDate date;
    private String notes;

    public EmployeeDTO() {
        super();
    }
}