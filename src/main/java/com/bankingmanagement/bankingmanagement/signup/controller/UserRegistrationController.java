package com.bankingmanagement.bankingmanagement.signup.controller;

import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.signup.exception.UserRegistrationException;
import com.bankingmanagement.bankingmanagement.signup.model.Customer;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import com.bankingmanagement.bankingmanagement.signup.model.User;
import com.bankingmanagement.bankingmanagement.signup.model.UserInfo;
import com.bankingmanagement.bankingmanagement.signup.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
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
        return "register";
    }


    @RequestMapping(path = "/signup", method = POST)
    public String register_user(@ModelAttribute("user") User user, BindingResult bindingResult, HttpSession session, ModelMap modelMap)
    {
        if(!bindingResult.hasErrors()){
            try {
                UserInfo userInfo = getUserInfo(user);
                String username = registrationService.registerUser(userInfo);
                session.setAttribute("username",username);
                return "user";
            } catch (UserRegistrationException e) {
                e.printStackTrace();
                modelMap.put("errorMsg", e.getErrorMessage());
                return "register";
            }
        }
        return "register";
    }

    private UserInfo getUserInfo(User user) {

        Customer customer = new Customer(user.getCustomerID(),user.getFirstName(),user.getLastName(),user.getAddress1(),user.getAddress2(),user.getCity(),user.getZipCode(),user.getContactNumber(),user.getEmail(),user.getSin());
        SecurityAnswer securityAnswer = new SecurityAnswer(user.getCustomerID(),user.getQuestionID(),user.getQuestionAnswer());
        UserLogin userLogin = new UserLogin(user.getCustomerID(),user.getPassword());

        return new UserInfo(customer,securityAnswer,userLogin);

    }

}
