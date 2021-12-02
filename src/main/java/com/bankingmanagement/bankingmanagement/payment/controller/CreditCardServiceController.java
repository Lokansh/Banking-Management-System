package com.bankingmanagement.bankingmanagement.payment.controller;

import com.bankingmanagement.bankingmanagement.payment.service.CreditCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CreditCardServiceController {
   @Autowired
   CreditCardService creditCardService;
   @RequestMapping(value = "/ccServices", method= RequestMethod.GET)
   public String getCCHome()
   {
      return "CCServicesHome";
   }


}
