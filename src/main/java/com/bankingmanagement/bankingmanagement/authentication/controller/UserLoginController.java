package com.bankingmanagement.bankingmanagement.authentication.controller;

import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.authentication.service.LoginService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.USER_ROLE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserLoginController {

    private final LoginService proxyLoginService;

    public UserLoginController(@Qualifier("proxyLoginService") LoginService proxyLoginService) {
        this.proxyLoginService = proxyLoginService;
    }

    @RequestMapping("/login")
    public String getLogin()
    {
        return "login";
    }

    @GetMapping("/user")
    public String getProfile()
    {
        return "user";
    }

    @RequestMapping(path = "/login", method = POST)
    public String loginUser(@ModelAttribute UserLogin userLogin, HttpSession session, ModelMap modelMap)
    {
        try {
            userLogin.setRole(USER_ROLE);
            proxyLoginService.validateUser(userLogin);

            session.setAttribute("username",userLogin.getUserLoginID());
            session.setAttribute("role",USER_ROLE);
            System.out.println("here");
            return "redirect:/user";

        } catch (UserAuthenticationException | InvalidRoleException e) {
            e.printStackTrace();
            modelMap.put("errorMsg", e.getMessage());

            return "login";
        }
    }

    @GetMapping(value = "/logout")
    public String logoutUser(HttpSession session,ModelMap modelMap)
    {
        try {
            proxyLoginService.logout(session.getAttribute("username").toString());
        } catch (Exception  e) {
            e.printStackTrace();
            return "redirect:/login";
        }
        session.removeAttribute("username");
        session.removeAttribute("role");
        session.invalidate();
        return "redirect:/login";
    }
}
