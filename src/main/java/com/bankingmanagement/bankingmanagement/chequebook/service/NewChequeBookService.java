package com.bankingmanagement.bankingmanagement.chequebook.service;

import com.bankingmanagement.bankingmanagement.chequebook.exception.ChequeBookException;

public interface NewChequeBookService {
    boolean submitNewChequeRequest(String customerId) throws ChequeBookException;
}
