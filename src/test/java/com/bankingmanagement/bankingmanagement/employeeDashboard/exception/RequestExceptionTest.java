package com.bankingmanagement.bankingmanagement.employeeDashboard.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequestExceptionTest {

	@Test
	public void requestExceptionClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.employeeDashboard.exception.RequestException"));
	}
	
	@Test
	public void getErrorMessageTest() {
		RequestException testObject=new RequestException("error occured");
		assertEquals(testObject.getErrorMessage(),"error occured");
	} 

}
