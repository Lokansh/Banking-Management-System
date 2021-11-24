package com.bankingmanagement.bankingmanagement.cardsChequebook.service;

import com.bankingmanagement.bankingmanagement.cardsChequebook.exception.CardsChequeBookException;

public interface CardsChequeBookService {

    String getCardsDetails(String id) throws CardsChequeBookException;

}
