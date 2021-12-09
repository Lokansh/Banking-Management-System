package com.bankingmanagement.bankingmanagement.card.controller;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.service.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;

class CardControllerTest {

    @Test
    void cardHome() {
        String expected = "cardHome";
        NewCardService newCardService= Mockito.mock(NewCardService.class);
        BlockCardService blockCardService = Mockito.mock(BlockCardService.class);
        ResetPinService resetPinService = Mockito.mock(ResetPinService.class);
        CardEligibilityService cardEligibilityService = Mockito.mock(CardEligibilityService.class);
        ModifyLimitService modifyLimitService = Mockito.mock(ModifyLimitService.class);

        CardController cardController = new CardController(newCardService,blockCardService,resetPinService,
                                                            cardEligibilityService,modifyLimitService);

        String actual = cardController.cardHome();

        assertEquals(expected,actual);
    }

    @Test
    void applyCard() {

        String expected = "applyCard";
        NewCardService newCardService= Mockito.mock(NewCardService.class);
        BlockCardService blockCardService = Mockito.mock(BlockCardService.class);
        ResetPinService resetPinService = Mockito.mock(ResetPinService.class);
        CardEligibilityService cardEligibilityService = Mockito.mock(CardEligibilityService.class);
        ModifyLimitService modifyLimitService = Mockito.mock(ModifyLimitService.class);

        CardController cardController = new CardController(newCardService,blockCardService,resetPinService,
                                                            cardEligibilityService,modifyLimitService);

        String actual = cardController.applyCard();

        assertEquals(expected,actual);
    }

    @Test
    void cardRequest() throws CardException {

        String cardType = "Credit";
        HttpSession session = Mockito.mock(HttpSession.class);
        ModelMap modelMap =  Mockito.mock(ModelMap.class);

        String expected = "applyCard";
        NewCardService newCardService= Mockito.mock(NewCardService.class);
        BlockCardService blockCardService = Mockito.mock(BlockCardService.class);
        ResetPinService resetPinService = Mockito.mock(ResetPinService.class);
        CardEligibilityService cardEligibilityService = Mockito.mock(CardEligibilityService.class);
        ModifyLimitService modifyLimitService = Mockito.mock(ModifyLimitService.class);

        Mockito.when(session.getAttribute("username")).thenReturn("user");
        Mockito.when(newCardService.submitNewCardRequest("user",cardType)).thenReturn(true);

        CardController cardController = new CardController(newCardService,blockCardService,resetPinService,
                cardEligibilityService,modifyLimitService);

        String actual = cardController.cardRequest(cardType,session,modelMap);

        verify(modelMap,times(1)).put("Request","Yes");
        assertEquals(expected,actual);
    }

    @Test
    void blockCard() {
    }

    @Test
    void testCardRequest() {
    }

    @Test
    void resetPin() {
    }

    @Test
    void pinChangeRequest() {
    }

    @Test
    void cardEligibility() {
    }

    @Test
    void cardEligibilityCheck() {
    }

    @Test
    void modifyLimit() {
    }

    @Test
    void checkLimit() {
    }

    @Test
    void testModifyLimit() {
    }

    @Test
    void modifyLimitRequest() {
    }
}