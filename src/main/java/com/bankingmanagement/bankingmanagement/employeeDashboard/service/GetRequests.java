package com.bankingmanagement.bankingmanagement.employeeDashboard.service;

import java.util.List;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.RequestException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Request;

public interface GetRequests {

	List<Request> getRequest() throws RequestException;
	List<Request> approvedHistory() throws RequestException;
	List<Request> deniedHistory() throws RequestException;
	List<Request> autoApprovedHistory() throws RequestException;
	void approveRequest(int requestId) throws RequestException;
	void denyRequest(int requestId) throws RequestException;
}
