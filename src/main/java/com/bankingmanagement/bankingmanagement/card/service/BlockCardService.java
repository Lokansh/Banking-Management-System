package com.bankingmanagement.bankingmanagement.card.service;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;

public interface BlockCardService {
    boolean submitBlockCardRequest(String customerId, String cardNumber, String cardType) throws CardException;
}
