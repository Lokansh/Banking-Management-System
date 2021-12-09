package com.bankingmanagement.bankingmanagement.employeeDashboard.model;

public class GetCustomer {
	private String customerId;

	public GetCustomer(String id) {
		customerId = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}
