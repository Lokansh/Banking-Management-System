package com.bankingmanagement.bankingmanagement.ccservice.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.ccservice.database.CreditCardConstants.CARD_TABLE;
@Component
public class CCDaoImpl implements CCDao{
    @Override
    public String fetchAllCCTableQuery(String userId) {
        return " SELECT * FROM " + CARD_TABLE +" WHERE CustomerID = "+ "\"" + userId + "\"; ";
    }
}
