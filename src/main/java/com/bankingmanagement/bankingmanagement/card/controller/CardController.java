package com.bankingmanagement.bankingmanagement.card.controller;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CardController {

    @RequestMapping(path= "/card", method = GET)
    public String home()
    {
        return "card";
    }
}
