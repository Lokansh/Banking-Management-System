package com.bankingmanagement.bankingmanagement.fundManipulation.database;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class GetStatementDaoImplTest {
	@Test
	public void getCustomerDaoImplClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.fundManipulation.database.GetStatementDaoImpl"));
	}
	@Test
	void testGetStatement() {
		GetStatementDaoImpl testObject=new  GetStatementDaoImpl();
		String expectedQuery="SELECT * FROM CSCI5308_20_PRODUCTION.Transactions where CustomerID='id';";
		assertEquals(testObject.getStatement("id"),expectedQuery);
	}

}
