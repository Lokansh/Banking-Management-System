package com.bankingmanagement.bankingmanagement.admin.model;

import com.bankingmanagement.bankingmanagement.admin.service.EmployeeVisitor;

public interface EmployeeElement {
	int accept(EmployeeVisitor visitor);
}
