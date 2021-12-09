package com.bankingmanagement.bankingmanagement.admin.controller;

import com.bankingmanagement.bankingmanagement.admin.exception.EmployeeNotFoundException;
import com.bankingmanagement.bankingmanagement.admin.service.SalaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

import static com.bankingmanagement.bankingmanagement.admin.database.SalaryConstant.ADMIN_ROLE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
public class AdminController {

	private final SalaryService salaryService;

	public AdminController(SalaryService salaryService) {
		this.salaryService = salaryService;
	}

	@RequestMapping("/admin")
	public String getLogin()
	{
		return "admin";
	}

	@RequestMapping(path="/salary",method = POST)
	public String getSalary(@RequestParam String employeeName, HttpSession session, ModelMap modelMap){
		try {
			String role = (String) session.getAttribute("role");

			if(role.equals(ADMIN_ROLE)){
				int salary= salaryService.calculateSalary(employeeName);

				session.setAttribute("employeeName",employeeName);
				session.setAttribute("isSalary",true);
				session.setAttribute("salary",salary);
				return "admin";
			}
			modelMap.put("errorMsg", "Only Admin is allowed to check salary");
			return "admin";
		} catch (EmployeeNotFoundException e) {
			modelMap.put("errorMsg", e.getErrorMessage());
			e.printStackTrace();
			return "admin";
		}
	}
}
