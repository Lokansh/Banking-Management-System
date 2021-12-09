package com.bankingmanagement.bankingmanagement.card.service;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;

public interface NewCardService {
    boolean submitNewCardRequest(String customerId, String cardType) throws CardException;
}
