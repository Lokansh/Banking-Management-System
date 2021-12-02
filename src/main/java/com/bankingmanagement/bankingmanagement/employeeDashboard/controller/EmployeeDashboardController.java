package com.bankingmanagement.bankingmanagement.employeeDashboard.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.CustomerDataException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.RequestException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Customer;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Employee;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.GetCustomer;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Request;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.EmployeeDetailsService;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.GetCustomerDataService;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.GetRequests;

@Controller
public class EmployeeDashboardController {

	@Autowired
	EmployeeDetailsService employeeDetailsService;

	@Autowired
	GetCustomerDataService getCustomerDataService;
	
	@Autowired
	GetRequests getRequests;
	
	@GetMapping(path = "/emp-dash/details")
	public String home(HttpSession session, ModelMap modelMap) throws EmployeeDetailsException {
		Employee empDetails=employeeDetailsService.getEmployeeDetails("111");
		session.setAttribute("fName", empDetails.getEmployeeFirstName());
		session.setAttribute("lName", empDetails.getEmployeeLastName());
		session.setAttribute("manager", empDetails.getEmployeeManager());
		session.setAttribute("salary", empDetails.getEmployeeSalary());
		session.setAttribute("id", "111");
		return "employeeDashboard";
	}

	@GetMapping(path = "/emp-dash/cust-details")
	public String custDetails() throws EmployeeDetailsException {
		return "findCustomer";
	}
	
	@RequestMapping(path = "/emp-dash/cust-details/data", method = POST)
    public String customersDetails(GetCustomer customer, HttpSession session, ModelMap modelMap) throws CustomerDataException
    {    
    	session.setAttribute("custSearchId",customer.getCustomerId());
    	Customer cust=getCustomerDataService.getCustomerDetails(customer.getCustomerId());
    	
    	session.setAttribute("cFName",cust.getFirstName());
    	session.setAttribute("cLName",cust.getLastName());
    	session.setAttribute("add1",cust.getAddress1());
    	session.setAttribute("add2",cust.getAddress2());
    	session.setAttribute("city",cust.getCity());
    	session.setAttribute("zip",cust.getZipCode());
    	session.setAttribute("email",cust.getEmail());
    	session.setAttribute("phone",cust.getPhone());
    	session.setAttribute("sin",cust.getSin());
    	if(cust.getBalance() != null) {
    	session.setAttribute("balance",cust.getBalance());
    	}
    	else {
    		session.setAttribute("balance",0);
    	}
    	
        return "customerDetails";
        
    }
	
	@GetMapping(path = "/emp-dash/requests")
	public String getRequest(HttpSession session) throws EmployeeDetailsException, RequestException {
		List<Request> req=getRequests.getRequest();
//		session.setAttribute("requests",req);
		return "requests";
	}
}
