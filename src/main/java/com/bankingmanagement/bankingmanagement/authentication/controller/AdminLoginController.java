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

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.ADMIN_ROLE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AdminLoginController {
    private final LoginService proxyLoginService;

    public AdminLoginController(@Qualifier("proxyLoginService") LoginService proxyLoginService) {
        this.proxyLoginService = proxyLoginService;
    }

    @RequestMapping("/adminlogin")
    public String getLogin()
    {
        return "adminlogin";
    }


    @RequestMapping(path = "/adminlogin", method = POST)
    public String loginAdmin(@ModelAttribute UserLogin userLogin, HttpSession session, ModelMap modelMap)
    {
        try {
            userLogin.setRole(ADMIN_ROLE);
            proxyLoginService.validateUser(userLogin);
            session.setAttribute("username",userLogin.getUserLoginID());
            session.setAttribute("role",ADMIN_ROLE);
            return "redirect:/admin";

        } catch (UserAuthenticationException | InvalidRoleException e) {
            e.printStackTrace();
            modelMap.put("errorMsg", e.getMessage());
            return "adminlogin";
        }
    }

    @GetMapping(value = "/adminlogout")
    public String logoutAdmin(HttpSession session,ModelMap modelMap)
    {
        try {
            proxyLoginService.logout(session.getAttribute("username").toString());
        } catch (Exception  e) {
            e.printStackTrace();
            return "redirect:/adminlogin";
        }
        session.removeAttribute("username");
        session.removeAttribute("role");
        session.invalidate();
        return "redirect:/adminlogin";
    }
}
