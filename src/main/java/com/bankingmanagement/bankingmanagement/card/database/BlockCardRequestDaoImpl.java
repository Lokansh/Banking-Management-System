package com.bankingmanagement.bankingmanagement.card.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.*;
import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.REQUEST_TYPE;

@Component
public class BlockCardRequestDaoImpl implements BlockCardRequestDao{
    @Override
    public String submitBlockCardRequestQuery(String customerId,String cardType) {
        String requestType = BLOCK + " " + cardType;
        return "INSERT INTO " + CARD_REQUEST_TABLE + "(" +
                CUSTOMER_ID + ", " +
                REQUEST_TYPE  + ", " +
                REQUEST_STATUS  +
                ") " +
                "VALUES (" +
                "\"" + customerId + "\", " +
                "\"" + requestType  + "\", " +
                "\"" + AUTO_APPROVED  + "\"" +
                ");";
    }

    @Override
    public String blockCard(String customerId, String cardNumber) {
        return "UPDATE " + CARD_TABLE +
                " SET " + CARD_STATUS + " = 'Blocked' WHERE " +
                CARD_NUMBER + "=\"" + cardNumber + "\"" + " AND " +
                CUSTOMER_ID + "=\"" + customerId + "\";";
    }
}
