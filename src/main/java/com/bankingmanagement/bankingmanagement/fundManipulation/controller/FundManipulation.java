package com.bankingmanagement.bankingmanagement.fundManipulation.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bankingmanagement.bankingmanagement.fundManipulation.exception.CustomerDataException;
import com.bankingmanagement.bankingmanagement.fundManipulation.exception.FundTransferException;
import com.bankingmanagement.bankingmanagement.fundManipulation.exception.StatementException;
import com.bankingmanagement.bankingmanagement.fundManipulation.model.Customer;
import com.bankingmanagement.bankingmanagement.fundManipulation.model.Statement;
import com.bankingmanagement.bankingmanagement.fundManipulation.service.CustomerDetailsService;
import com.bankingmanagement.bankingmanagement.fundManipulation.service.FundTransferService;
import com.bankingmanagement.bankingmanagement.fundManipulation.service.GetStatementService;

@Controller
public class FundManipulation {
	@Autowired
	CustomerDetailsService customerDetailService;
	@Autowired
	GetStatementService getStatementService;
	@Autowired
	FundTransferService fundTransferService;

	
	@GetMapping(path = "/cust-dash/home")
	public String custHome() {
		return "customerHome";
	}

	@GetMapping(path = "/cust-dash/balance")
	public String custBalance(HttpSession session, ModelMap modelMap) throws CustomerDataException {
		String id = (String) session.getAttribute("username");
		Customer c1 = customerDetailService.getDetails(id);
		session.setAttribute("custSearchId", id);
		session.setAttribute("account", c1.getAccount());
		if (c1.getBalance() != null) {
			session.setAttribute("balance", c1.getBalance());
		} else {
			session.setAttribute("balance", 0);
		}
		return "custBalance";
	}

	@GetMapping(path = "/cust-dash/details")
	public String custDetails(HttpSession session, ModelMap modelMap) throws CustomerDataException {
		String id = (String) session.getAttribute("username");
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

	@GetMapping(path = "/cust-dash/transfer-home")
	public String transferHome(HttpSession session, ModelMap modelMap) throws CustomerDataException {

		return "fund-transfer-home";
	}

	@GetMapping(path = "/cust-dash/statement")
	public String custStatement(HttpSession session, ModelMap modelMap)
			throws CustomerDataException, StatementException {
		String id = (String) session.getAttribute("username");
		List<Statement> statements = getStatementService.getStatement(id);
		modelMap.clear();
		modelMap.put("statements", statements);
		return "statement";
	}

	@PostMapping(path = "/cust-dash/transfer")
	public String transfer(HttpSession session, ModelMap modelMap, @RequestParam("recipient-id") String recipient,
			@RequestParam("amount") int amount, @RequestParam("methodType") String methodType) throws CustomerDataException, StatementException {
		String id = (String) session.getAttribute("username");
		try {
			fundTransferService.transferFund(id, recipient, amount, methodType);
		}catch (FundTransferException e) {
			modelMap.put("errorMsg",e.getErrorMessage());
		}
		
		return "transfer";
	}

}
