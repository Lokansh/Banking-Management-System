package com.bankingmanagement.bankingmanagement.fundManipulation.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class FundManipulationDaoImplTest {
	@Test
	public void fundManipulationDaoImplClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.fundManipulation.database.FundManipulationDaoImpl"));
	}
	FundManipulationDaoImpl testObject = new FundManipulationDaoImpl();
	@Test
	void testUpdateBalance() {
		String expectedQuery="UPDATE `CSCI5308_20_PRODUCTION`.`Customer_Account` SET `Balance` = 101.0 WHERE `CustomerID` = 'id';";
		assertEquals(testObject.updateBalance("id",101),expectedQuery);
	}

	@Test
	void testGetBalance() {
		String expectedQuery="SELECT Balance FROM CSCI5308_20_PRODUCTION.Customer_Account where CustomerID='id';";
		assertEquals(testObject.getBalance("id"),expectedQuery);
	}

}
