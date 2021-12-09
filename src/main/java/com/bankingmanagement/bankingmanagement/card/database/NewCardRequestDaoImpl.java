package com.bankingmanagement.bankingmanagement.card.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.*;
import static com.bankingmanagement.bankingmanagement.card.database.CardConstants.REQUEST_TYPE;

@Component
public class NewCardRequestDaoImpl implements NewCardRequestDao{
    @Override
    public String submitNewCardRequestQuery(String customerId, String cardType) {
        String requestType = NEW + " " + cardType;
        return "INSERT INTO " + CARD_REQUEST_TABLE + "(" +
                CUSTOMER_ID + ", " +
                REQUEST_TYPE  + ", " +
                REQUEST_STATUS  +
                ") " +
                "VALUES (" +
                "\"" + customerId + "\", " +
                "\"" + requestType  + "\", " +
                "\"" + PENDING  + "\"" +
                ");";
    }
}
