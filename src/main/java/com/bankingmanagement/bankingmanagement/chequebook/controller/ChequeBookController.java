package com.bankingmanagement.bankingmanagement.chequebook.controller;

import com.bankingmanagement.bankingmanagement.chequebook.exception.ChequeBookException;
import com.bankingmanagement.bankingmanagement.chequebook.service.NewChequeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class ChequeBookController {

    @Autowired
    NewChequeBookService newChequeBookService;

    //Chequebook Home
    @RequestMapping(path= "/chequebookHome", method = GET)
    public String chequeHome()
    {
        return "chequebookHome";
    }

    // Apply for a new chequebook block - Start
    @RequestMapping(path= "/applyChequebook", method = GET)
    public String applyCheque()
    {
        return "applyChequebook";
    }

    @RequestMapping(value = "/applyChequebook", method= RequestMethod.POST)
    public String cardRequest(HttpSession session, ModelMap modelMap) {

        String userId = (String) session.getAttribute("username");
        try {
            boolean req = newChequeBookService.submitNewChequeRequest(userId);

            if (req){
                modelMap.put("Request","Yes");
            }
            else{
                modelMap.put("errorMsg", "Can't submit your new cheque book request");
            }
        } catch (ChequeBookException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "applyChequebook";
    }
    // Apply for a new chequebook block - End

}
