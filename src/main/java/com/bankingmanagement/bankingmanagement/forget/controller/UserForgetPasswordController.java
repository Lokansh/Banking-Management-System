package com.bankingmanagement.bankingmanagement.forget.controller;


import com.bankingmanagement.bankingmanagement.forget.exception.NewPasswordException;
import com.bankingmanagement.bankingmanagement.forget.exception.UserForgetPasswordException;
import com.bankingmanagement.bankingmanagement.forget.service.ForgetPasswordService;
import com.bankingmanagement.bankingmanagement.forget.service.NewPasswordService;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class UserForgetPasswordController {

    @Autowired
    private ForgetPasswordService forgetPasswordService;

    @Autowired
    private NewPasswordService newPasswordService;

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
        System.out.println(username);
        try {
            String user= newPasswordService.saveNewPassword(username,password);
            session.removeAttribute("new_password");
            return "redirect:user";

        } catch (NewPasswordException e) {
            modelMap.put("errorMsg", e.getErrorMessage());
            e.printStackTrace();
            return "newpassword";
        }
    }

    @RequestMapping(path = "/forget", method = POST)
    public String changePassword(@ModelAttribute("securityAnswer") SecurityAnswer securityAnswer, BindingResult bindingResult, HttpSession session, ModelMap modelMap)
    {
        if(!bindingResult.hasErrors()){
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
        return "forget";
    }


}
