package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequestDaoImplTest {
	
	@Test
	public void requestDaoImplClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.employeeDashboard.database.RequestDaoImpl"));
	}

RequestDaoImpl req=new RequestDaoImpl();
	@Test
	void testGetRequests() {
		String expectedQuery="SELECT * FROM CSCI5308_20_PRODUCTION.Customer_Request where Status='Pending';";
		assertEquals(req.getRequests(), expectedQuery);
	}

	@Test
	void testApprovedRequestHistory() {
		String expectedQuery="SELECT * FROM CSCI5308_20_PRODUCTION.Customer_Request where Status='APPROVED';";
		assertEquals(req.approvedRequestHistory(), expectedQuery);
	}

	@Test
	void testDeniedRequestHistory() {
		String expectedQuery="SELECT * FROM CSCI5308_20_PRODUCTION.Customer_Request where Status='DENIED';";
		assertEquals(req.deniedRequestHistory(), expectedQuery);
	}

	@Test
	void testAutoApprovedRequestHistory() {
		String expectedQuery="SELECT * FROM CSCI5308_20_PRODUCTION.Customer_Request where Status='AUTO-APPROVED';";
		assertEquals(req.autoApprovedRequestHistory(), expectedQuery);
	}

}
