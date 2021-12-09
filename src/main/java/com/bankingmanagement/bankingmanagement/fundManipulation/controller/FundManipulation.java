package com.bankingmanagement.bankingmanagement.fundManipulation.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.bankingmanagement.bankingmanagement.fundManipulation.exception.CustomerDataException;
import com.bankingmanagement.bankingmanagement.fundManipulation.model.Customer;
import com.bankingmanagement.bankingmanagement.fundManipulation.service.CustomerDetailsService;

@Controller
public class FundManipulation {
	@Autowired
	CustomerDetailsService customerDetailService;

	@GetMapping(path = "/cust-dash/home")
	public String custHome() {
		return "customerHome";
	}

	@GetMapping(path = "/cust-dash/balance")
	public String custBalance(HttpSession session, ModelMap modelMap) throws CustomerDataException {
		String id = "abhas";
		Customer c1 = customerDetailService.getDetails(id);
		session.setAttribute("custSearchId", id);
		session.setAttribute("account", c1.getAccount());
		if (c1.getBalance() != null) {
			session.setAttribute("balance", c1.getBalance());
		} else {
			session.setAttribute("balance", 0);
		}
		return "customerBalance";
	}

	@GetMapping(path = "/cust-dash/details")
	public String custDetails(HttpSession session, ModelMap modelMap) throws CustomerDataException {
		String id = "abhas";
		Customer c1 = customerDetailService.getDetails(id);
		session.setAttribute("custSearchId", id);
		session.setAttribute("cFName", c1.getFirstName());
		session.setAttribute("cLName", c1.getLastName());
		session.setAttribute("add1", c1.getAddress1());
		session.setAttribute("add2", c1.getAddress2());
		session.setAttribute("city", c1.getCity());
		session.setAttribute("zip", c1.getZipCode());
		session.setAttribute("email", c1.getEmail());
		session.setAttribute("phone", c1.getPhone());
		session.setAttribute("sin", c1.getSin());
		session.setAttribute("account", c1.getAccount());
		if (c1.getBalance() != null) {
			session.setAttribute("balance", c1.getBalance());
		} else {
			session.setAttribute("balance", 0);
		}
		return "custDetails";
	}

	@GetMapping(path = "/cust-dash/imps")
	public String custImps(HttpSession session, ModelMap modelMap) throws CustomerDataException {

		return "imps";
	}
	
	@GetMapping(path = "/cust-dash/neft")
	public String custNeft(HttpSession session, ModelMap modelMap) throws CustomerDataException {

		return "neft";
	}
	
	@GetMapping(path = "/cust-dash/rtgs")
	public String custRtgs(HttpSession session, ModelMap modelMap) throws CustomerDataException {

		return "rtgs";
	}

}
