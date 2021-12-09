package com.bankingmanagement.bankingmanagement.admin.controller;

import com.bankingmanagement.bankingmanagement.admin.exception.EmployeeNotFoundException;
import com.bankingmanagement.bankingmanagement.admin.service.SalaryService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AdminControllerTest {

	@Test
	void getLogin() {
		SalaryService salaryService = Mockito.mock(SalaryService.class);
		String expected = "admin";

		AdminController adminController = new AdminController(salaryService);
		String actual = adminController.getLogin();

		assertEquals(expected,actual);
	}

	@Test
	void getSalary() throws EmployeeNotFoundException {
		String expected = "admin";

		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);
		String employeeName = "employee";
		int salary = 10000;

		SalaryService salaryService = Mockito.mock(SalaryService.class);
		AdminController adminController = new AdminController(salaryService);

		Mockito.when(session.getAttribute("role")).thenReturn("admin");
		Mockito.when(salaryService.calculateSalary(employeeName)).thenReturn(salary);

		String actual =adminController.getSalary(employeeName,session,modelMap);

		verify(session, times(1)).setAttribute("employeeName",employeeName);
		verify(session,times(1)).setAttribute("salary",salary);

		assertEquals(expected,actual);
	}
}