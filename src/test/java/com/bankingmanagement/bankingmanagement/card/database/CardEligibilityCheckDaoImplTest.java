package com.bankingmanagement.bankingmanagement.card.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardEligibilityCheckDaoImplTest {

    @Test
    void checkEligibilityQuery() {
        String expectedQuery = "SELECT * FROM Credit_Score WHERE SIN=\"3424234\" AND CustomerId=\"user\";";
        CardEligibilityCheckDaoImpl cardEligibilityCheckDaoImpl = new CardEligibilityCheckDaoImpl();
        String customerId = "user";
        String sin = "3424234";

        String actualQuery = cardEligibilityCheckDaoImpl.checkEligibilityQuery(customerId,sin);
        assertEquals(expectedQuery,actualQuery);
    }
}