package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

public interface ManageRequestsDao {

	String approveRequest(int requestId);

	String denyRequest(int requestId);

}