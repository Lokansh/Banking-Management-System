package com.bankingmanagement.bankingmanagement.chequebook.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewChequeBookRequestDaoImplTest {

    @Test
    void submitNewChequeRequestQuery() {
        String expectedQuery = "INSERT INTO CustomerRequest(CustomerId, Request, Status) VALUES (\"lokansh\", \"New ChequeBook\", \"Pending\");";
        NewChequeBookRequestDaoImpl newChequeBookRequestDao = new NewChequeBookRequestDaoImpl();
        String username = "lokansh";

        String actualQuery = newChequeBookRequestDao.submitNewChequeRequestQuery(username);
        assertEquals(expectedQuery,actualQuery);
    }
}