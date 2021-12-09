package com.bankingmanagement.bankingmanagement.signup.controller;

import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.signup.exception.UserRegistrationException;
import com.bankingmanagement.bankingmanagement.signup.model.Customer;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import com.bankingmanagement.bankingmanagement.signup.model.User;
import com.bankingmanagement.bankingmanagement.signup.model.UserInfo;
import com.bankingmanagement.bankingmanagement.signup.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.USER_ROLE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserRegistrationController {

    private final RegistrationService registrationService;

    public UserRegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @RequestMapping("/signup")
    public String getSignup()
    {
        return "register";
    }


    @RequestMapping(path = "/signup", method = POST)
    public String registerUser(@ModelAttribute("user") User user, HttpSession session, ModelMap modelMap)
    {
            try {
                UserInfo userInfo = getUserInfo(user);
                String username = registrationService.registerUser(userInfo);
                session.setAttribute("username",username);
                session.setAttribute("role",USER_ROLE);
                return "redirect:user";
            } catch (UserRegistrationException e) {
                e.printStackTrace();
                modelMap.put("errorMsg", e.getErrorMessage());
                return "register";
            }
    }

    private UserInfo getUserInfo(User user) {

        Customer customer = new Customer(user.getCustomerID(),user.getFirstName(),user.getLastName(),user.getAddress1(),user.getAddress2(),user.getCity(),user.getZipCode(),user.getContactNumber(),user.getEmail(),user.getSin());
        SecurityAnswer securityAnswer = new SecurityAnswer(user.getCustomerID(),user.getQuestionID(),user.getQuestionAnswer());
        UserLogin userLogin = new UserLogin(user.getCustomerID(),user.getPassword(),"user");

        return new UserInfo(customer,securityAnswer,userLogin);

    }

}
