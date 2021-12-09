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

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.EMPLOYEE_ROLE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class EmployeeLoginController {
	private final LoginService proxyLoginService;

	public EmployeeLoginController(@Qualifier("proxyLoginService") LoginService proxyLoginService) {
		this.proxyLoginService = proxyLoginService;
	}

	@RequestMapping("/employeelogin")
	public String getLogin()
	{
		return "employeelogin";
	}


	@RequestMapping(path = "/employeelogin", method = POST)
	public String loginEmployee(@ModelAttribute UserLogin userLogin, HttpSession session, ModelMap modelMap)
	{
		try {
			userLogin.setRole(EMPLOYEE_ROLE);
			proxyLoginService.validateUser(userLogin);
			session.setAttribute("username",userLogin.getUserLoginID());
			session.setAttribute("role",EMPLOYEE_ROLE);
			return "redirect:/employeeDashboard";

		} catch (UserAuthenticationException | InvalidRoleException e) {
			e.printStackTrace();
			modelMap.put("errorMsg", e.getMessage());
			return "employeelogin";
		}
	}

	@GetMapping(value = "/employeelogout")
	public String logoutEmployee(HttpSession session,ModelMap modelMap)
	{
		try {
			proxyLoginService.logout(session.getAttribute("username").toString());
		} catch (Exception  e) {
			e.printStackTrace();
			return "redirect:/employeelogin";
		}
		session.removeAttribute("username");
		session.removeAttribute("role");
		session.invalidate();
		return "redirect:/employeelogin";
	}
}
