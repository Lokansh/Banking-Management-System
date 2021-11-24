package com.bankingmanagement.bankingmanagement.employeeDashboard.service;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Employee;

public interface EmployeeDetailsService {

	Employee getEmployeeDetails(String id) throws EmployeeDetailsException;

}
