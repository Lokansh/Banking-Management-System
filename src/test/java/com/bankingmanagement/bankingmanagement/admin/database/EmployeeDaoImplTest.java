package com.bankingmanagement.bankingmanagement.admin.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeDaoImplTest {

	@Test
	void getEmployeeQuery() {
		String expectedQuery = "SELECT EmployeeID, WorkingHours, BonusPay, IsManager FROM Employees WHERE EmployeeID=\"employee\";";
		EmployeeDaoImpl employeeDao = new EmployeeDaoImpl();
		String username= "employee";

		String actualQuery = employeeDao.getEmployeeQuery(username);
		assertEquals(expectedQuery,actualQuery);
	}
}