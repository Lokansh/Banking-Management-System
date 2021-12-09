package com.bankingmanagement.bankingmanagement.card.service;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.model.CreditScore;

public interface CardEligibilityService {
    CreditScore checkCreditScore(String customerId, String sin) throws CardException;
}
