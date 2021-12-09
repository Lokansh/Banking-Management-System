package com.bankingmanagement.bankingmanagement.employeeDashboard.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.bankingmanagement.bankingmanagement.fundManipulation.exception.CustomerDataException;

class EmployeeDetailsExceptionTest {

	@Test
	public void employeeDetailsExceptionClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException"));
	}
	
	@Test
	public void getErrorMessageTest() {
		EmployeeDetailsException testObject=new EmployeeDetailsException("error occured");
		assertEquals(testObject.getErrorMessage(),"error occured");
	} 
	

}
