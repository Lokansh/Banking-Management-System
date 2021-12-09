package com.bankingmanagement.bankingmanagement.fundManipulation.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetDetailsDaoImplTest {

	@Test
	public void getCustomerDaoImplClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.fundManipulation.database.GetDetailsDaoImpl"));
	}
	GetDetailsDaoImpl testObject=new  GetDetailsDaoImpl();
	@Test
	void testGetCustomerData() {
		
		String expectedQuery="SELECT * FROM Customer INNER JOIN `Customer_Account` on Customer.CustomerID = `Customer_Account`.CustomerID where Customer.CustomerID='id';";
		assertEquals(testObject.getCustomerData("id"),expectedQuery);
	}

	@Test
	void testGetCustomerBalance() {
		String expectedQuery="SELECT * FROM `Customer_Account` where CustomerID='id';";
		assertEquals(testObject.getCustomerBalance("id"),expectedQuery);
	}

}
