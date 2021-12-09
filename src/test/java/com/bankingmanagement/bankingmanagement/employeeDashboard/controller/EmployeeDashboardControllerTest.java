package com.bankingmanagement.bankingmanagement.employeeDashboard.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;

class EmployeeDashboardControllerTest {

	@Test
	public void getEmployeeDetailsDaoImplClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.fundManipulation.controller.FundManipulation"));
	}
	EmployeeDashboardController testObject=new EmployeeDashboardController();
	@Test
	void testCustHome() throws EmployeeDetailsException {
		assertEquals("findCustomer", testObject.custDetails());
	}
}
