package com.bankingmanagement.bankingmanagement.cardsChequebook.controller;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;

public class CardsChequeBookController {


    @RequestMapping(path= "/emp-details", method = GET)
    public String home()
    {
        return "Cards & Cheque Book Details";
    }


}
