package com.bankingmanagement.bankingmanagement.admin.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeNotFoundExceptionTest {

	@Test
	void getErrorMessage() {
		EmployeeNotFoundException employeeNotFoundException = new EmployeeNotFoundException("Wrong EmployeeID");

		assertEquals("Wrong EmployeeID",employeeNotFoundException.getErrorMessage());
	}
}