package com.bankingmanagement.bankingmanagement.deposit.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepositExceptionTest {

    @Test
    void getErrorMessage() {
        DepositException depositException = new DepositException("Wrong Exception");

        assertEquals("Wrong Exception",depositException.getErrorMessage());
    }

}