package com.bankingmanagement.bankingmanagement.card.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.*;
import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.CUSTOMER_ID;

@Component
public class ResetPinDaoImpl implements ResetPinDao{
    @Override
    public String resetPinQuery(String customerId, String cardNumber, String cardPin) {
        return "UPDATE " + CARD_TABLE +
                " SET " + CARD_PIN + "=\"" + cardPin + "\"" + " WHERE " +
                CARD_NUMBER + "=\"" + cardNumber + "\"" + " AND " +
                CUSTOMER_ID + "=\"" + customerId + "\";";
    }
}
