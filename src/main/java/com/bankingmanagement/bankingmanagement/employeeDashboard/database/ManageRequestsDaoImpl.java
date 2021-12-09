package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import org.springframework.stereotype.Component;

@Component
public class ManageRequestsDaoImpl implements ManageRequestsDao {
	@Override
	public String  approveRequest(int requestId) {
		return "UPDATE CSCI5308_20_PRODUCTION.Customer_Request SET Status = 'APPROVED' WHERE RequestId = "+requestId+";";
	};
	@Override
	public String  denyRequest(int requestId) {
		return "UPDATE CSCI5308_20_PRODUCTION.Customer_Request SET Status = 'DENIED' WHERE RequestId = "+requestId+";";
	};
}
