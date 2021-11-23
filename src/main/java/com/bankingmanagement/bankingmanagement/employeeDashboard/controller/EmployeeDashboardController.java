package com.bankingmanagement.bankingmanagement.employeeDashboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.EmployeeDetailsService;

@Controller
public class EmployeeDashboardController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	@GetMapping(path = "/emp-dash/details")
	public String home(Model model) throws EmployeeDetailsException {
		System.out.println("1111111111111");
		String empDetails=employeeDetailsService.getEmployeeDetails("111");
		
		return empDetails;
	}

}
