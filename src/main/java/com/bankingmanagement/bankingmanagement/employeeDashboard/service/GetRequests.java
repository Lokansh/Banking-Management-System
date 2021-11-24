package com.bankingmanagement.bankingmanagement.employeeDashboard.service;

import java.util.List;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.RequestException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Customer;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Request;

public interface GetRequests {

	List<Request> getRequest() throws RequestException;
}
