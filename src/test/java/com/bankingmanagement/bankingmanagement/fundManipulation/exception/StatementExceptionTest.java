package com.bankingmanagement.bankingmanagement.fundManipulation.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StatementExceptionTest {

	@Test
	public void statementExceptionClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.fundManipulation.exception.StatementException"));
	}
	
	@Test
	public void getErrorMessageTest() {
		StatementException testObject=new StatementException("error occured");
		assertEquals(testObject.getErrorMessage(),"error occured");
	} 

}
