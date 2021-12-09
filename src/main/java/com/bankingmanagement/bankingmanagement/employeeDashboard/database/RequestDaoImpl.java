package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import org.springframework.stereotype.Component;

@Component
public class RequestDaoImpl implements RequestDao {
	@Override
	public String getRequests() {
		return "SELECT * FROM CSCI5308_20_PRODUCTION.Customer_Request where Status='Pending';";
	};

	@Override
	public String  approvedRequestHistory() {
		return "SELECT * FROM CSCI5308_20_PRODUCTION.Customer_Request where Status='APPROVED';";
	};
	
	@Override
	public String  deniedRequestHistory() {
		return "SELECT * FROM CSCI5308_20_PRODUCTION.Customer_Request where Status='DENIED';";
	};
	
	@Override
	public String  autoApprovedRequestHistory() {
		return "SELECT * FROM CSCI5308_20_PRODUCTION.Customer_Request where Status='AUTO-APPROVED';";
	};
}
