package com.bankingmanagement.bankingmanagement.fundManipulation.exception;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FundTransferExceptionTest {

	@Test
	public void fundTransferExceptionClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.fundManipulation.exception.FundTransferException"));
	}
	
	@Test
	public void getErrorMessageTest() {
		FundTransferException testObject=new FundTransferException("error occured");
		assertEquals(testObject.getErrorMessage(),"error occured");
	} 
}
