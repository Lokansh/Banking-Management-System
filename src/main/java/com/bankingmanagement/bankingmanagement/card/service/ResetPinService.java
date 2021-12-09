package com.bankingmanagement.bankingmanagement.card.service;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;

public interface ResetPinService {
    boolean resetPinRequest(String customerId, String cardNumber, String cardPin) throws CardException;
}