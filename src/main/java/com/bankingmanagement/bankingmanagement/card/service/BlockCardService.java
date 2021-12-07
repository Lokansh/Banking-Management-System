package com.bankingmanagement.bankingmanagement.card.service;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.model.Card;
import java.util.List;

public interface BlockCardService {
    boolean submitBlockCardRequest(String customerId, String cardNumber, String cardType) throws CardException;
}
