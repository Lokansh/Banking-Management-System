package com.bankingmanagement.bankingmanagement.card.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.bankingmanagement.bankingmanagement.card.exception.CardException;
import com.bankingmanagement.bankingmanagement.card.model.CreditScore;
import com.bankingmanagement.bankingmanagement.card.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class CardController {
    private final NewCardService newCardService;

    private final BlockCardService blockCardService;

    private final ResetPinService resetPinService;

    private final CardEligibilityService cardEligibilityService;

    private final ModifyLimitService modifyLimitService;

    public CardController(NewCardService newCardService, BlockCardService blockCardService, ResetPinService resetPinService, CardEligibilityService cardEligibilityService, ModifyLimitService modifyLimitService) {
        this.newCardService = newCardService;
        this.blockCardService = blockCardService;
        this.resetPinService = resetPinService;
        this.cardEligibilityService = cardEligibilityService;
        this.modifyLimitService = modifyLimitService;
    }

    //Home page
    @RequestMapping(path= "/cardHome", method = GET)
    public String cardHome()
    {
        return "cardHome";
    }

    // Apply for a new card block - Start
    @RequestMapping(path= "/applyCard", method = GET)
    public String applyCard()
    {
        return "applyCard";
    }

    @RequestMapping(value = "/applyCard", method= RequestMethod.POST)
    public String cardRequest(@RequestParam("cardType")String cardType, HttpSession session, ModelMap modelMap) {

        String userId = (String) session.getAttribute("username");
        try {
            boolean req = newCardService.submitNewCardRequest(userId,cardType);

            if (req){
                modelMap.put("Request","Yes");
            }
            else{
                modelMap.put("errorMsg", "Can't submit your new card request");
                System.out.println("here");
            }
        } catch (CardException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "applyCard";
    }
    // Apply for a new card block - End

    // block card block - Start
    @RequestMapping(path= "/blockCard", method = GET)
    public String blockCard()
    {
        return "blockCard";
    }

    @RequestMapping(value = "/blockCard", method= RequestMethod.POST)
    public String cardRequest(@RequestParam("cardType")String cardType, @RequestParam("cardNumber")String cardNumber, HttpSession session, ModelMap modelMap) {

        String userId = (String) session.getAttribute("username");
        try {
            boolean req = blockCardService.submitBlockCardRequest(userId,cardNumber,cardType);

            if (req){
                modelMap.put("Request","Yes");
            }
            else{
                modelMap.put("errorMsg", "Could not process your block card request as your card does not exist.");
            }
        } catch (CardException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "blockCard";
    }
    // block card block - end

    // reset card pin block - start
    @RequestMapping(path= "/resetPin", method = GET)
    public String resetPin()
    {
        return "resetCardPin";
    }

    @RequestMapping(value = "/resetPin", method= RequestMethod.POST)
    public String pinChangeRequest(@RequestParam("cardPin")String cardPin, @RequestParam("cardNumber")String cardNumber, HttpSession session, ModelMap modelMap) {

        String userId = (String) session.getAttribute("username");
        try {
            boolean req = resetPinService.resetPinRequest(userId,cardNumber,cardPin);

            if (req){
                modelMap.put("Request","Yes");
            }
            else{
                modelMap.put("errorMsg", "Could not process your PIN change request as Card was not valid.");
            }
        } catch (CardException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "resetCardPin";
    }
    // reset card pin block - end

    // credit card eligibility check block - start
    @RequestMapping(path= "/cardEligibility", method = GET)
    public String cardEligibility()
    {
        return "creditCardEligibility";
    }

    @RequestMapping(value = "/cardEligibility", method= RequestMethod.POST)
    public String cardEligibilityCheck(@RequestParam("sin")String sin, HttpSession session, ModelMap modelMap) {

        String userId = (String) session.getAttribute("username");
        try {
            CreditScore score = cardEligibilityService.checkCreditScore(userId,sin);
            String creditScore = null;
            if (score != null){
                creditScore = score.getCreditScore();
                Integer creditScoreInt = Integer.parseInt(creditScore);
                System.out.println("creditScoreInt - " + creditScoreInt);
                if(creditScoreInt > 750) {
                    modelMap.put("RequestSuccess", "Yes");
                }
                else{
                    modelMap.put("RequestDeny", "Yes");
                }
            }
            else{
                modelMap.put("errorMsg", "Could not fetch your credit score as it does not exist.");
            }
        } catch (CardException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "creditCardEligibility";
    }
    // credit card eligibility check block - end

    // modify card limit block - start
    @RequestMapping(path= "/modifyLimit", method = GET)
    public String modifyLimit()
    {
        return "cardLimitModify";
    }

    @RequestMapping(value = "/checkLimit", method= RequestMethod.GET)
    public String checkLimit(HttpSession session, ModelMap modelMap) {
        String userId = (String) session.getAttribute("username");
        try
        {
            String cardLimit =modifyLimitService.checkLimit(userId);
            if(cardLimit!=null) {
                modelMap.put("CreditCardLimit", cardLimit);
            }
            else
            {
                modelMap.put("errorMsg", "Sorry we dont have your credit score in our records");
            }
        }
        catch (CardException e){
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "cardLimitModify";
    }

    @RequestMapping(value = "/changeLimit", method= RequestMethod.GET)
    public String modifyLimit(HttpSession session, ModelMap modelMap) {
        modelMap.put("ChangeLimit","Yes");
        return "cardLimitModify";
    }

    @RequestMapping(value = "/changeLimit", method= RequestMethod.POST)
    public String modifyLimitRequest(@RequestParam("cardNumber")String cardNumber, @RequestParam("newLimit")String newLimit,
                                     HttpSession session, ModelMap modelMap) {

        String userId = (String) session.getAttribute("username");
        try {
            boolean req = modifyLimitService.modifyLimitRequest(userId,cardNumber,newLimit);
            System.out.println("req -" + req);
            if (req){
                modelMap.put("Request",newLimit);
            }
            else{
                modelMap.put("errorMsg", "Could not process your limit modification, please enter correct card number");
            }
        } catch (CardException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
        }
        return "cardLimitModify";
    }
    // modify card limit block - end
}
