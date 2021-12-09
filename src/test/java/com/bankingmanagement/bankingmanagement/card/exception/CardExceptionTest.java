package com.bankingmanagement.bankingmanagement.card.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardExceptionTest {

    @Test
    void getErrorMessage() {
        CardException cardException = new CardException("Wrong Exception");

        assertEquals("Wrong Exception",cardException.getErrorMessage());
    }
}