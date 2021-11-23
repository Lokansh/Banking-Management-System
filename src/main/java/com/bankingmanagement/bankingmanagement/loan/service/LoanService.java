package com.bankingmanagement.bankingmanagement.loan.service;

import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;

public interface LoanService {

    String getLoanDetails(String id) throws LoanException;

}
