package com.bankingmanagement.bankingmanagement.chequebook.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.chequebook.database.ChequeBookConstants.*;

@Component
public class NewChequeBookRequestDaoImpl implements NewChequeBookRequestDao {
    @Override
    public String submitNewChequeRequestQuery(String customerId) {
        String requestType = NEW + " " + CHEQUEBOOK;
        return "INSERT INTO " + CHEQUE_REQUEST_TABLE + "(" +
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
