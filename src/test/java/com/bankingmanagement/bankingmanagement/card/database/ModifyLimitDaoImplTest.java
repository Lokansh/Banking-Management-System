package com.bankingmanagement.bankingmanagement.card.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ModifyLimitDaoImplTest {

    @Test
    void checkCardLimit() {
        String expectedQuery = "SELECT * FROM Card WHERE CustomerId=\"user\";";
        ModifyLimitDaoImpl modifyLimitDaoImpl = new ModifyLimitDaoImpl();
        String customerId = "user";

        String actualQuery = modifyLimitDaoImpl.checkCardLimit(customerId);
        assertEquals(expectedQuery,actualQuery);
    }

    @Test
    void modifyLimitQuery() {
        String expectedQuery = "UPDATE Card SET CardLimit=\"242342\" WHERE CardNumber=\"2432423\" AND CustomerId=\"user\";";
        ModifyLimitDaoImpl modifyLimitDaoImpl = new ModifyLimitDaoImpl();
        String customerId = "user";
        String cardNumber = "2432423";
        String newlimit = "242342";

        String actualQuery = modifyLimitDaoImpl.modifyLimitQuery(customerId,cardNumber,newlimit);
        assertEquals(expectedQuery,actualQuery);
    }
}