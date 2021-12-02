package com.bankingmanagement.bankingmanagement.card.service;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;

public interface CardService {

    String getCardsDetails(String id) throws CardException;

}
