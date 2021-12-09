package com.bankingmanagement.bankingmanagement.deposit.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OpenFixedDepositDaoImplTest {

    @Test
    void getCustomerDetails() {
        String expectedQuery = "SELECT * FROM Customer_Account WHERE CustomerId=\"user\"LIMIT 1;";
        OpenFixedDepositDaoImpl openFixedDepositDaoImpl = new OpenFixedDepositDaoImpl();
        String username = "user";

        String actualQuery = openFixedDepositDaoImpl.getCustomerDetails(username);
        assertEquals(expectedQuery,actualQuery);
    }
/*
    @Test
    void openFixedDepositQuery() {
    }

    @Test
    void deductBalanceFromCustomerAccount() {
    }

 */
}