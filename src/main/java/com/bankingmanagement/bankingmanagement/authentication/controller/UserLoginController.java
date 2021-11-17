package com.bankingmanagement.bankingmanagement.authentication.controller;

import com.bankingmanagement.bankingmanagement.authentication.exception.userAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.serviceImplemenation.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

import com.bankingmanagement.bankingmanagement.authentication.model.Customer;

@Controller
public class UserLoginController {

    @Autowired
    private LoginServiceImpl loginService;

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }

    @RequestMapping("/signup")
    public String getSignup()
    {
        return "signup";
    }

    @RequestMapping("/login")
    public String getLogin()
    {
        return "login";
    }

    @GetMapping("/user")
    public String dummy()
    {
        return "user";
    }

    @PostMapping("/login")
    public String login_user(@RequestParam("username") String username, @RequestParam("password") String password, HttpSession session, ModelMap modelMap)
    {

        try {
            loginService.validateUser(username,password);
            session.setAttribute("username",username);
            return "user";
        } catch (userAuthenticationException e) {
            e.printStackTrace();
            modelMap.put("errorMsg", e.getErrorMessage());
            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String logout_user(HttpSession session)
    {
        session.removeAttribute("username");
        session.invalidate();
        return "redirect:/login";
    }
}
