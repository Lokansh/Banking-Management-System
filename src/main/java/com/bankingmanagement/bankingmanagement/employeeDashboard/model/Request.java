package com.bankingmanagement.bankingmanagement.employeeDashboard.model;

public class Request {
	Integer customerId; 
	String requestData; 
	String Status; 
	Integer RequestId;
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
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public Integer getRequestId() {
		return RequestId;
	}
	public void setRequestId(Integer requestId) {
		RequestId = requestId;
	}
}
