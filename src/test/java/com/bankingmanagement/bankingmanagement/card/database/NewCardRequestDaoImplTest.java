package com.bankingmanagement.bankingmanagement.card.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewCardRequestDaoImplTest {

    @Test
    void submitNewCardRequestQuery() {
        String expectedQuery = "INSERT INTO Customer_Request(CustomerId, Request, Status) VALUES (\"user\", \"New debit\", \"Pending\");";
        NewCardRequestDaoImpl newCardRequestDaoImpl = new NewCardRequestDaoImpl();
        String customerId = "user";
        String cardType = "debit";

        String actualQuery = newCardRequestDaoImpl.submitNewCardRequestQuery(customerId,cardType);
        assertEquals(expectedQuery,actualQuery);
    }
}