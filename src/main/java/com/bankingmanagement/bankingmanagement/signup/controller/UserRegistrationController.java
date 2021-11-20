package com.bankingmanagement.bankingmanagement.signup.controller;

import com.bankingmanagement.bankingmanagement.signup.exception.UserRegistrationException;
import com.bankingmanagement.bankingmanagement.signup.model.UserInfo;
import com.bankingmanagement.bankingmanagement.signup.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @RequestMapping("/signup")
    public String getSignup()
    {
        return "signup";
    }


    @RequestMapping(path = "/signup", method = POST)
    public String register_user(UserInfo userInfo, HttpSession session, ModelMap modelMap)
    {
        try {
            String username = registrationService.registerUser(userInfo);
            session.setAttribute("username",username);
            return "user";
        } catch (UserRegistrationException e) {
            e.printStackTrace();
            modelMap.put("errorMsg", e.getErrorMessage());
            return "signup";
        }
    }

}
