package com.bankingmanagement.bankingmanagement.deposit.controller;

import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;
import com.bankingmanagement.bankingmanagement.deposit.service.CloseFixedDepositService;
import com.bankingmanagement.bankingmanagement.deposit.service.OpenFixedDepositService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import java.util.Calendar;
import java.util.List;

import static com.bankingmanagement.bankingmanagement.deposit.database.DepositConstants.*;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class DepositController {

    @Autowired
    OpenFixedDepositService openFixedDepositService;

    @Autowired
    CloseFixedDepositService closeFixedDepositService;

    public static CustomerAccount customerAccount;
    public static CustomerAccount customerAccountClose;
    public static Deposit deposit;
    List<Deposit> depositList;

    //Deposit Home page
    @RequestMapping(path= "/depositHome", method = GET)
    public String depositHome(){
        return "depositHome";
    }

    //Open Fixed deposit - Start
    @RequestMapping(path= "/openFD", method = GET)
    public String openFD(HttpSession session, ModelMap modelMap){
        String userId = (String) session.getAttribute("username");
        try{
            customerAccount = openFixedDepositService.getAccount(userId);
            if(customerAccount!=null) {
                modelMap.put("AccountNumber", customerAccount.getAccountId());
                modelMap.put("Balance", customerAccount.getBalance());
                modelMap.put("FixedDepositInterest", FIXED_DEPOSIT_INTEREST);
            }
            else
            {
                modelMap.put("errorMsg", "Sorry we don't have your account in our bank.");
            }
        }
        catch (DepositException e){
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "openFD";
    }

    @RequestMapping(value = "/openFD", method= RequestMethod.POST)
    public String modifyLimitRequest(@RequestParam("amount")String amount, @RequestParam("tenure")String tenure,
                                     HttpSession session, ModelMap modelMap) {
        if(amount==null || amount.trim().isEmpty()) {
            modelMap.put("errorMsg", "Please enter amount.");
        }
        if(tenure==null || tenure.trim().isEmpty()) {
            modelMap.put("errorMsg", "Please enter tenure.");
        }
        modelMap.put("AccountNumber", customerAccount.getAccountId());
        modelMap.put("Balance", customerAccount.getBalance());
        modelMap.put("FixedDepositInterest", FIXED_DEPOSIT_INTEREST);

        String userId = (String) session.getAttribute("username");

        java.util.Date dateTime = new java.util.Date();
        java.text.SimpleDateFormat simpleDateFormat = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fdOpenDate = simpleDateFormat.format(dateTime);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, Integer.parseInt(tenure));
        java.util.Date dt = cal.getTime();
        java.text.SimpleDateFormat simpleDateFormat2 = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fdMaturityDate = simpleDateFormat2.format(dt);

        deposit = new Deposit(userId,amount,FIXED_DEPOSIT,tenure,FIXED_DEPOSIT_INTEREST,fdOpenDate,fdMaturityDate);

        try {
            Boolean depositSuccess = openFixedDepositService.fdRequest(deposit,customerAccount);
            if(depositSuccess){
                customerAccount = openFixedDepositService.getAccount(userId);
                if(customerAccount!=null) {
                    modelMap.put("AccountNumber", customerAccount.getAccountId());
                    modelMap.put("Balance", customerAccount.getBalance());
                    modelMap.put("FixedDepositInterest", FIXED_DEPOSIT_INTEREST);
                }
                modelMap.put("Request","Yes");
            }
            else{
                modelMap.put("errorMsg", "Can't submit your fixed deposit request");
            }
        } catch (DepositException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "openFD";
    }
    //Open Fixed deposit - end

    //Close Fixed deposit - start
    @RequestMapping(path= "/closeFD", method = GET)
    public String closeFD(HttpSession session, ModelMap modelMap){
        String userId = (String) session.getAttribute("username");
        try
        {
            customerAccountClose = openFixedDepositService.getAccount(userId);
            if(customerAccountClose!=null) {
                modelMap.put("AccountNumber", customerAccountClose.getAccountId());
                modelMap.put("Balance", customerAccountClose.getBalance());
            }
            else
            {
                modelMap.put("errorMsg", "Sorry we don't have your account in our bank.");
            }
            depositList = closeFixedDepositService.getAllDeposit(userId);
            if(depositList.size() > 0){
                modelMap.put("depositList", depositList);
            }
        }
        catch (DepositException e){
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "closeFD";
    }

    @RequestMapping(value = "/closeFD", method= RequestMethod.POST)
    public String liquidateDeposit(@RequestParam("selected")String depositId, HttpSession session, ModelMap modelMap) {
        String userId = (String) session.getAttribute("username");

        Deposit localDeposit = null;
        for(Deposit dp : depositList){
            if(dp.getDepositId().equals(depositId)){
                localDeposit = dp;
            }
        }
        if(localDeposit != null && customerAccountClose != null){
            try{
                Boolean closeDepositSuccess = closeFixedDepositService.liquidateDeposit(localDeposit,customerAccountClose);
                System.out.println(closeDepositSuccess + " closeDepositSuccess");
                if(closeDepositSuccess){
                    customerAccountClose = openFixedDepositService.getAccount(userId);
                    if(customerAccountClose != null) {
                        modelMap.put("AccountNumber", customerAccountClose.getAccountId());
                        modelMap.put("Balance", customerAccountClose.getBalance());
                    }
                    modelMap.put("Request", "Yes");
                    depositList.clear();
                    depositList = closeFixedDepositService.getAllDeposit(userId);
                    if(depositList.size() > 0){
                        modelMap.put("depositList", depositList);
                    }
                }
                else{
                    modelMap.put("errorMsg", "Can't process your liquidate deposit request");
                }
            } catch (DepositException e) {
                modelMap.put("errorMsg", e.getErrorMessage());
            }
        }

        return "closeFD";
    }
    //Close Fixed deposit - end
}
