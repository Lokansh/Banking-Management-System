package com.bankingmanagement.bankingmanagement.card.service;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;

public interface ModifyLimitService {
    String checkLimit(String customerId) throws CardException;
    boolean modifyLimitRequest(String customerId, String cardNumber, String newLimit) throws CardException;
}
