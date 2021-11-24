package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import org.springframework.stereotype.Component;

@Component
public class RequestDaoImpl implements RequestDao {
@Override
	public String  getRequests() {
		return "SELECT * FROM CSCI5308_20_PRODUCTION.CustomerRequest where Status='Pending';";
	};
}
