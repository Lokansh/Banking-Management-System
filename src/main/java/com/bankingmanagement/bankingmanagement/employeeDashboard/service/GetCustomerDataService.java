package com.bankingmanagement.bankingmanagement.employeeDashboard.service;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.CustomerDataException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Customer;

public interface GetCustomerDataService {
	Customer getCustomerDetails(String id) throws CustomerDataException;
}
