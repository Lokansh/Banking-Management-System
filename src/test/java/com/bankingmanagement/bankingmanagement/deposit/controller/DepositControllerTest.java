package com.bankingmanagement.bankingmanagement.deposit.controller;

import com.bankingmanagement.bankingmanagement.card.controller.CardController;
import com.bankingmanagement.bankingmanagement.card.service.*;
import com.bankingmanagement.bankingmanagement.deposit.service.CloseFixedDepositService;
import com.bankingmanagement.bankingmanagement.deposit.service.OpenFixedDepositService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class DepositControllerTest {

    @Test
    void depositHome() {
        String expected = "depositHome";
        OpenFixedDepositService openFixedDepositService= Mockito.mock(OpenFixedDepositService.class);
        CloseFixedDepositService closeFixedDepositService= Mockito.mock(CloseFixedDepositService.class);

        DepositController depositController = new DepositController(openFixedDepositService,closeFixedDepositService);

        String actual = depositController.depositHome();

        assertEquals(expected,actual);
    }

    @Test
    void openFD() {
    }

    @Test
    void modifyLimitRequest() {
    }

    @Test
    void closeFD() {
    }

    @Test
    void liquidateDeposit() {
    }
}