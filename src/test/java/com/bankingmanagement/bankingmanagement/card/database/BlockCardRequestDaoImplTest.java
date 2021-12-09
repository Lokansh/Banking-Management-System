package com.bankingmanagement.bankingmanagement.card.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BlockCardRequestDaoImplTest {

    @Test
    void submitBlockCardRequestQuery() {
        String expectedQuery = "INSERT INTO Customer_Request(CustomerId, Request, Status) VALUES (\"user\", \"Block Credit Card\", \"AUTO-APPROVED\");";
        BlockCardRequestDaoImpl blockCardRequestDaoImpl = new BlockCardRequestDaoImpl();
        String username = "user";
        String cardType = "Credit Card";

        String actualQuery = blockCardRequestDaoImpl.submitBlockCardRequestQuery(username,cardType);
        //System.out.println(actualQuery);
        assertEquals(expectedQuery,actualQuery);
    }

    @Test
    void blockCard() {
        String expectedQuery = "INSERT INTO Customer_Request(CustomerId, Request, Status) VALUES (\"user\", \"Block 34324324324\", \"AUTO-APPROVED\");";
        BlockCardRequestDaoImpl blockCardRequestDaoImpl = new BlockCardRequestDaoImpl();
        String username = "user";
        String cardNumber = "34324324324";

        String actualQuery = blockCardRequestDaoImpl.submitBlockCardRequestQuery(username,cardNumber);
        //System.out.println(actualQuery);
        assertEquals(expectedQuery,actualQuery);
    }
}