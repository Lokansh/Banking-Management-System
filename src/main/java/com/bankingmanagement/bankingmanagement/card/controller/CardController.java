package com.bankingmanagement.bankingmanagement.card.controller;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CardController {

    @RequestMapping(path= "/cardHome", method = GET)
    public String cardHome()
    {
        return "cardHome";
    }


    @RequestMapping(path= "/cardHome", method = GET)
    public String home()
    {
        return "cardHome";
    }


}
