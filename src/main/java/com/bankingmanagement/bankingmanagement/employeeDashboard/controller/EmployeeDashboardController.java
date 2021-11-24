package com.bankingmanagement.bankingmanagement.employeeDashboard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Employee;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.EmployeeDetailsService;

@Controller
public class EmployeeDashboardController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	@GetMapping(path = "/emp-dash/details")
	public String home(HttpSession session, ModelMap modelMap) throws EmployeeDetailsException {
		System.out.println("1111111111111");
		Employee empDetails=employeeDetailsService.getEmployeeDetails("111");
		session.setAttribute("fName", empDetails.getEmployeeFirstName());
		session.setAttribute("lName", empDetails.getEmployeeLastName());
		session.setAttribute("manager", empDetails.getEmployeeManager());
		session.setAttribute("salary", empDetails.getEmployeeSalary());
		session.setAttribute("id", "111");
		return "employeeDashboard";
	}

}
