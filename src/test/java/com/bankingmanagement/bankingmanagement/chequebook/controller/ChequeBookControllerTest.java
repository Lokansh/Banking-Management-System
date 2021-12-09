package com.bankingmanagement.bankingmanagement.chequebook.controller;

import com.bankingmanagement.bankingmanagement.card.controller.CardController;
import com.bankingmanagement.bankingmanagement.card.service.*;
import com.bankingmanagement.bankingmanagement.chequebook.service.NewChequeBookService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ChequeBookControllerTest {

    @Test
    void chequeHome() {
        String expected = "chequebookHome";
        NewChequeBookService newChequeBookService= Mockito.mock(NewChequeBookService.class);

        ChequeBookController chequeBookController = new ChequeBookController(newChequeBookService);

        String actual = chequeBookController.chequeHome();

        assertEquals(expected,actual);
    }

    @Test
    void applyCheque() {
        String expected = "applyChequebook";
        NewChequeBookService newChequeBookService= Mockito.mock(NewChequeBookService.class);

        ChequeBookController chequeBookController = new ChequeBookController(newChequeBookService);

        String actual = chequeBookController.applyCheque();

        assertEquals(expected,actual);
    }

}