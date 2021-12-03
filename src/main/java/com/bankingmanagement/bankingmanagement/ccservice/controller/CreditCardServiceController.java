package com.bankingmanagement.bankingmanagement.ccservice.controller;

import com.bankingmanagement.bankingmanagement.ccservice.exception.CreditCardException;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditCardInfo;
import com.bankingmanagement.bankingmanagement.ccservice.service.CreditCardService;
import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class CreditCardServiceController {
   @Autowired
   CreditCardService creditCardService;
   @RequestMapping(value = "/ccServices", method= RequestMethod.GET)
   public String getCCHome()
   {
      return "ccServicesHome";
   }

   @RequestMapping(value = "/ccList", method= RequestMethod.GET)
   public String getAllCC(HttpSession session, ModelMap modelMap)
   {
      String userId = (String) session.getAttribute("username");
      try {
         List<CreditCardInfo> ccList=creditCardService.getCCList(userId);
         if(ccList!=null){
            modelMap.put("ccdetails", ccList);}
         else
         {
            modelMap.put("errorMsg", "No Credit Card associated with this account");
         }
      }
      catch (CreditCardException e){
         e.printStackTrace();
         modelMap.put("errorMsg", e.getErrorMessage());

      }
      return "ccList";
   }

}
