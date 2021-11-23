package com.bankingmanagement.bankingmanagement.loan.controller;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;

public class LoanController {


    @RequestMapping(path= "/loan", method = GET)
    public String loan()
    {
        return "Loan Page";
    }


}
