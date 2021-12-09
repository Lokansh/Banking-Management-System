package com.bankingmanagement.bankingmanagement.fundManipulation.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerDataExceptionTest {

	@Test
	public void customerDataExceptionClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.fundManipulation.exception.CustomerDataException"));
	}
	
	@Test
	public void getErrorMessageTest() {
		CustomerDataException testObject=new CustomerDataException("error occured");
		assertEquals(testObject.getErrorMessage(),"error occured");
	} 
	
	

}
