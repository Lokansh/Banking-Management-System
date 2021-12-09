package com.bankingmanagement.bankingmanagement.fundManipulation.service;

import com.bankingmanagement.bankingmanagement.fundManipulation.exception.CustomerDataException;
import com.bankingmanagement.bankingmanagement.fundManipulation.model.Customer;

public interface CustomerDetailsService {

	Customer getDetails(String id) throws CustomerDataException;
}
