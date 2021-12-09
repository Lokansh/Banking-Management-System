package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.test.web.client.ExpectedCount;

class ManageRequestsDaoImplTest {
	@Test
	public void getEmployeeDetailsDaoImplClassExists() throws ClassNotFoundException {
		  //checking whether the class exists or not
	      assertNotNull(Class.forName("com.bankingmanagement.bankingmanagement.employeeDashboard.database.ManageRequestsDaoImpl"));
	}
	
	ManageRequestsDaoImpl testObject=new ManageRequestsDaoImpl();
	
	@Test
	void testApproveRequest() {
		String expectedQuery="UPDATE CSCI5308_20_PRODUCTION.Customer_Request SET Status = 'APPROVED' WHERE RequestId = 123;";
		assertEquals(testObject.approveRequest(123),expectedQuery);
	}

	@Test
	void testDenyRequest() {
		String expectedQuery="UPDATE CSCI5308_20_PRODUCTION.Customer_Request SET Status = 'DENIED' WHERE RequestId = 123;";
		assertEquals(testObject.denyRequest(123),expectedQuery);
	}

}
