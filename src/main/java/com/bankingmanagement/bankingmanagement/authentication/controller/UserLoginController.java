package com.bankingmanagement.bankingmanagement.authentication.controller;

import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.authentication.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserLoginController {

    @Autowired
    private LoginService loginService;

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

    @RequestMapping(path = "/login", method = POST)
    public String login_user(UserLogin userLogin, HttpSession session, ModelMap modelMap)
    {
        try {
            loginService.validateUser(userLogin);
            session.setAttribute("username",userLogin.getUserLoginID());
            return "user";
        } catch (UserAuthenticationException e) {
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
