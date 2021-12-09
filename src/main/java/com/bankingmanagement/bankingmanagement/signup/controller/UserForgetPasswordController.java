package com.bankingmanagement.bankingmanagement.signup.controller;

import com.bankingmanagement.bankingmanagement.signup.exception.NewPasswordException;
import com.bankingmanagement.bankingmanagement.signup.exception.UserForgetPasswordException;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import com.bankingmanagement.bankingmanagement.signup.service.ForgetPasswordService;
import com.bankingmanagement.bankingmanagement.signup.service.NewPasswordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserForgetPasswordController {

    private final ForgetPasswordService forgetPasswordService;

    private final NewPasswordService newPasswordService;

    public UserForgetPasswordController(ForgetPasswordService forgetPasswordService, NewPasswordService newPasswordService) {
        this.forgetPasswordService = forgetPasswordService;
        this.newPasswordService = newPasswordService;
    }

    @RequestMapping("/forget")
    public String forgetPassword()
    {
        return "forget";
    }

    @RequestMapping("/newpassword")
    public String newPassword()
    {
        return "newpassword";
    }

    @RequestMapping(path="/newpassword",method = POST)
    public String updatePassword(@RequestParam String password,HttpSession session,ModelMap modelMap){
        String username = (String) session.getAttribute("username");
        try {
            String user= newPasswordService.saveNewPassword(username,password);
            session.removeAttribute("new_password");
            session.setAttribute("username",user);
            return "redirect:user";

        } catch (NewPasswordException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
            e.printStackTrace();
            return "newpassword";
        }
    }

    @RequestMapping(path = "/forget", method = POST)
    public String changePassword(@ModelAttribute("securityAnswer") SecurityAnswer securityAnswer, HttpSession session, ModelMap modelMap)
    {
            try {
                String username= forgetPasswordService.handleForgetPassword(securityAnswer);
                session.setAttribute("new_password",true);
                session.setAttribute("username",username);
                return "redirect:newpassword";
            } catch (UserForgetPasswordException e) {
                modelMap.put("errorMsg", e.getErrorMessage());
                e.printStackTrace();
                return "forget";
            }
    }

}
