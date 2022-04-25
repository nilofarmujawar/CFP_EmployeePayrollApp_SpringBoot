package com.bridgelabz.employeepayrollservice.repository;

import com.bridgelabz.employeepayrollservice.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * JPA is used tpo perform curd operations and customized operations as well
 */
public interface EmployeePayrollRepository extends JpaRepository<Employee, Integer> {
}