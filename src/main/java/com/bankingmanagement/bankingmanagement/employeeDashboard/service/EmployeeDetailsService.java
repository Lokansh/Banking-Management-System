package com.bankingmanagement.bankingmanagement.employeeDashboard.service;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;

public interface EmployeeDetailsService {

	String getEmployeeDetails(String id) throws EmployeeDetailsException;

}
