package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

public interface RequestDao {
	String getRequests();

	String approvedRequestHistory();

	String deniedRequestHistory();
	
	String autoApprovedRequestHistory();
}
