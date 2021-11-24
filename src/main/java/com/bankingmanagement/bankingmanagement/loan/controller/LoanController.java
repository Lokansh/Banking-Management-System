package com.bankingmanagement.bankingmanagement.loan.controller;

import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import com.bankingmanagement.bankingmanagement.loan.model.Loan;
import com.bankingmanagement.bankingmanagement.loan.service.LoanService;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import java.util.List;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class LoanController {
   @Autowired
    LoanService loanService;

    @RequestMapping(value = "/loanApplication", method= RequestMethod.GET)
    public String getloanApplication()
    {
        return "loanapp";
    }

    @RequestMapping(value = "/loanApplication", method= RequestMethod.POST)
    public String submitApplication(@ModelAttribute("loan") Loan loan, BindingResult bindingResult, HttpSession session, ModelMap modelMap)
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
    public String getloantypes()
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

}
