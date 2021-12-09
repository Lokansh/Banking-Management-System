package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetEmployeeDetailsDaoImplTest {
	@Test
	public void getEmployeeDetailsDaoImplClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.employeeDashboard.database.GetEmployeeDetailsDaoImpl"));
	}
	@Test
	void employeeQueryTest() {
		
		String expectedQuery="SELECT FirstName, LastName, Manager, Salary FROM Employee WHERE EmployeeId=\"test\";";
		GetEmployeeDetailsDaoImpl emp=new GetEmployeeDetailsDaoImpl();
		assertEquals(emp.getEmployeeDetailsData("test"),expectedQuery);
	}

}
