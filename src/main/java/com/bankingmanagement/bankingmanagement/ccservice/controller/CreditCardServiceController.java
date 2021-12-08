package com.bankingmanagement.bankingmanagement.ccservice.controller;

import com.bankingmanagement.bankingmanagement.ccservice.exception.CreditCardException;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditCardInfo;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditScoreInfo;
import com.bankingmanagement.bankingmanagement.ccservice.service.CreditCardService;
import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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
   {modelMap.remove("RequestTable");
      String userId = (String) session.getAttribute("username");
      try {
         List<CreditCardInfo> ccList=creditCardService.getCCList(userId);
         if(ccList.isEmpty()){
            modelMap.put("errorMsg", "No Credit Card associated with this account");
            }
         else
         {
            modelMap.put("ccdetails", ccList);
         }
      }
      catch (CreditCardException e){
         e.printStackTrace();
         modelMap.put("errorMsg", e.getErrorMessage());

      }
      return "ccList";
   }
   @RequestMapping(value = "/checkCreditScore", method= RequestMethod.GET)
   public String getCreditScore()
   {
      return "creditScore";
   }

   @RequestMapping(value = "/checkCreditScore", method= RequestMethod.POST)
   public String checkCreditScore(@RequestParam("sin") String sin,ModelMap modelMap) {
      modelMap.remove("RequestTable");
      try
      {
         CreditScoreInfo creditScore =creditCardService.getCreditScore(sin);
         if(creditScore!=null) {
            modelMap.put("CreditScore", creditScore.getCreditScore());
         }
         else
         {
            modelMap.put("errorMsg", "Sorry we dont have your credit score in our records");
         }
      }
      catch (CreditCardException e){
         e.printStackTrace();
         modelMap.put("errorMsg", e.getErrorMessage());

      }
      return "creditScore";
   }


   @RequestMapping(value = "/increaseCreditLimit", method= RequestMethod.GET)
   public String increaseLimit(HttpSession session, ModelMap modelMap) {
      String userId = (String) session.getAttribute("username");
      try {
         if (creditCardService.checkCustCC(userId)) {
            return "creditLimit";
         } else {
            modelMap.put("errorMsg", "Sorry you dont have a credit card");
            return "ccServicesHome";
         }
      }
      catch (CreditCardException e){
         e.printStackTrace();
         modelMap.put("errorMsg", e.getErrorMessage());
         return "ccServiceHome";
      }
   }
   @RequestMapping(value = "/checkCCLimit", method= RequestMethod.GET)
   public String checkCCLimit(HttpSession session, ModelMap modelMap) {
      String userId = (String) session.getAttribute("username");
      try
      {
         String ccLimit =creditCardService.getCreditCardLimit(userId);
         if(ccLimit!=null) {
            modelMap.put("CreditCardLimit", ccLimit);
            modelMap.remove("RequestTable");
         }
         else
         {
            modelMap.put("errorMsg", "Sorry we dont have your credit score in our records");
         }
      }
      catch (CreditCardException e){
         e.printStackTrace();
         modelMap.put("errorMsg", e.getErrorMessage());

      }
      return "creditLimit";
   }

   @RequestMapping(value = "/applyCCLimit", method= RequestMethod.GET)
   public String applyCCLimit(HttpSession session, ModelMap modelMap) {
      modelMap.put("ApplyLimitIncr","Yes");
      modelMap.remove("RequestTable");
      return "creditLimit";
   }

   @RequestMapping(value = "/applyCCLimit", method= RequestMethod.POST)
   public String ccLimitApp(@RequestParam("salary")String salary, HttpSession session, ModelMap modelMap) {

      String userId = (String) session.getAttribute("username");
      try {
        boolean req= creditCardService.submitRequest(userId,salary);

        if (req){
            modelMap.put("Request","Yes");
           modelMap.remove("ApplyLimitIncr");
         }
        else
        {
           throw new CreditCardException("Cant Submit Request");
        }
      } catch (CreditCardException e) {
         e.printStackTrace();
      }
      return "creditLimit";
   }
   @RequestMapping(value = "/fetchCCLimitRequest", method= RequestMethod.GET)
   public String ccLimitReq( HttpSession session, ModelMap modelMap) {
      modelMap.remove("ApplyLimitIncr");
      String userId = (String) session.getAttribute("username");
      try {
         String oldSalary =creditCardService.getSalary(userId);
         modelMap.put("oldSalary",oldSalary);
         modelMap.put("RequestTable","Yes");
      } catch (CreditCardException e) {
         e.printStackTrace();
      }
      return "creditLimit";
   }


}
