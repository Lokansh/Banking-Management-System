package com.bankingmanagement.bankingmanagement.chequebook.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChequeBookExceptionTest {

    @Test
    void getErrorMessage() {
        ChequeBookException chequeBookException = new ChequeBookException("Wrong Exception");

        assertEquals("Wrong Exception",chequeBookException.getErrorMessage());
    }
}