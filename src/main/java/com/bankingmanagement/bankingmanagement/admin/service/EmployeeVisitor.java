package com.bankingmanagement.bankingmanagement.admin.service;

import com.bankingmanagement.bankingmanagement.admin.model.Employee;
import com.bankingmanagement.bankingmanagement.admin.model.Manager;

public interface EmployeeVisitor {
	int visitEmployee(Employee employee);
	int visitManager(Manager manager);
}
