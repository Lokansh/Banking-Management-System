package com.bankingmanagement.bankingmanagement.loan.controller;

import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import com.bankingmanagement.bankingmanagement.loan.model.EligibilityInfo;
import com.bankingmanagement.bankingmanagement.loan.model.Loan;
import com.bankingmanagement.bankingmanagement.loan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoanController {
   @Autowired
    LoanService loanService;

    @RequestMapping(value = "/loanApplication", method= RequestMethod.GET)
    public String getLoanApplication()
    {
        return "loanapp";
    }

    @RequestMapping(value = "/loanApplication", method= RequestMethod.POST)
    public String submitApplication(@ModelAttribute("loan") Loan loan, HttpSession session, ModelMap modelMap)
    {
        try {
                String userId= (String) session.getAttribute("username");
                 loanService.applyLoan(loan,userId);
            modelMap.put("successMsg", "Loan Applied Successfully");
                return "loanapp";
            } catch (LoanException e) {
                e.printStackTrace();
                modelMap.put("errorMsg", e.getErrorMessage());
             return "loanapp";
            }

    }

    @RequestMapping("/loantypes")
    public String getLoanTypes()
    {
        return "loantypes";
    }

    @RequestMapping("/viewallApplication")
    public String loanApplications(HttpSession session,ModelMap modelMap)
    {
        String userId= (String) session.getAttribute("username");
        try {
            if(loanService.getAppliedLoans(userId)!=null){
            modelMap.put("loans", loanService.getAppliedLoans(userId));}
            else
            {
                modelMap.put("errorMsg", "No Loan Applications");
            }
        }
        catch (LoanException e){
            e.printStackTrace();
            modelMap.put("errorMsg", e.getErrorMessage());

        }
        return "viewapplications";
    }
    @RequestMapping(value = "/loanEligibility", method= RequestMethod.GET)
    public String getPreLoanForm()
    {
        return "preloanform";
    }

    @RequestMapping(value = "/loanEligibility", method= RequestMethod.POST)
    public String checkEligibilityAndInterest(@ModelAttribute("info") EligibilityInfo info, BindingResult bindingResult, HttpSession session, ModelMap modelMap)
    {
        try {
            String userId = (String) session.getAttribute("username");
            double check=loanService.checkEligibilityAndInterest(info, userId);
            if (check>0) {
                modelMap.put("Interest", check);
                modelMap.put("successMsg", "You are eligible to apply loan");
            } else {
                modelMap.put("errorMsg", "Sorry! you are not eligible to apply loan");
            }
            return "preloanform";
        }catch (LoanException e) {
            e.printStackTrace();
            modelMap.put("errorMsg", e.getErrorMessage());
            return "preloanform";
        }
    }
    @RequestMapping(value = "/deleteLoanApplication", method= RequestMethod.GET)
    public String deleteLoanApp(@RequestParam int id, ModelMap modelMap)
    {
        try {
            if(loanService.deleteLoanRequest(id))
            {modelMap.put("successMsg", "Requested Loan application deleted Successfully");}
            else
            {
                modelMap.put("errorMsg", "Requested Loan application cant be deleted");
            }
        } catch (LoanException e) {
            e.printStackTrace();
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "redirect:/viewallApplication";
    }
}
