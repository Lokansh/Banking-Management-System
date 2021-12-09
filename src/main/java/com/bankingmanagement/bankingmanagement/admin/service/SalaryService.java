package com.bankingmanagement.bankingmanagement.admin.service;

import com.bankingmanagement.bankingmanagement.admin.exception.EmployeeNotFoundException;

public interface SalaryService {
	int calculateSalary(String employeeName) throws EmployeeNotFoundException;
}
