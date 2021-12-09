package com.bankingmanagement.bankingmanagement.card.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResetPinDaoImplTest {

    @Test
    void resetPinQuery() {
        String expectedQuery = "UPDATE Card SET CardPin=\"32112\" WHERE CardNumber=\"32423432\" AND CustomerId=\"user\";";
        ResetPinDaoImpl resetPinDaoImpl = new ResetPinDaoImpl();
        String customerId = "user";
        String cardNumber = "32423432";
        String cardPin = "32112";

        String actualQuery = resetPinDaoImpl.resetPinQuery(customerId,cardNumber,cardPin);
        assertEquals(expectedQuery,actualQuery);
    }
}