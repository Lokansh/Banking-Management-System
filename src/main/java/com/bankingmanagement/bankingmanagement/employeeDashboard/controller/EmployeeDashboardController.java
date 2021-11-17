package com.bankingmanagement.bankingmanagement.employeeDashboard.controller;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.web.bind.annotation.RequestMapping;

public class EmployeeDashboardController {

	
	@RequestMapping(path= "/emp-details", method = GET)
    public String home()
    {
        return "Employee Details";
    }
	
	
}
