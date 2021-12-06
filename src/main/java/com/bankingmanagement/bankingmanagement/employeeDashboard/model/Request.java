package com.bankingmanagement.bankingmanagement.employeeDashboard.model;

import org.springframework.stereotype.Component;

@Component
public class Request {
	Integer customerId;
	String requestData;
	String status;
	Integer requestId;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int i) {
		this.customerId = i;
	}

	public String getRequestData() {
		return requestData;
	}

	public void setRequestData(String requestData) {
		this.requestData = requestData;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String reqStatus) {
		status = reqStatus;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer id) {
		requestId = id;
	}

}
