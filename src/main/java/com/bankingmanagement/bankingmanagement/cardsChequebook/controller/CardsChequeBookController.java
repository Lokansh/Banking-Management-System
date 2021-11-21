package com.bankingmanagement.bankingmanagement.cardsChequebook.controller;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CardsChequeBookController {

    @RequestMapping(path= "/cards", method = GET)
    public String home()
    {
        return "cards";
    }
}
