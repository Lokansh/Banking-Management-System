package com.bankingmanagement.bankingmanagement.cardsChequebook.service;

import com.bankingmanagement.bankingmanagement.cardsChequebook.exception.CardsChequeBookException;

public interface CardsChequeBookService {

    String getEmployeeDetails(String id) throws CardsChequeBookException;

}
