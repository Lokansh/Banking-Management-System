package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GetCustomerDaoImplTest {

	@Test
	public void getCustomerDaoImplClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.employeeDashboard.database.GetCustomerDaoImpl"));
	}
	
	@Test
	void testGetCustomerData() {
		GetCustomerDaoImpl testObject=new GetCustomerDaoImpl();
		String expectedQuery="SELECT * FROM Customer LEFT JOIN `Customer_Account` on Customer.CustomerID = `Customer_Account`.CustomerID where Customer.CustomerID='abc';";
		assertEquals(testObject.getCustomerData("abc"),expectedQuery);
	}

}
