package com.bankingmanagement.bankingmanagement.authentication.controller;

import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.authentication.service_implementation.ProxyLoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.EMPLOYEE_ROLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class EmployeeLoginControllerTest {

	@Test
	void getLogin() {
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		String expected = "employeelogin";
		EmployeeLoginController employeeLoginController = new EmployeeLoginController(proxyLoginService);

		String actual = employeeLoginController.getLogin();
		assertEquals(expected,actual);
	}

	@Test
	void loginEmployee() {
		String expected = "redirect:/employeeDashboard";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);

		EmployeeLoginController employeeLoginController = new EmployeeLoginController(proxyLoginService);

		UserLogin userLogin = Mockito.mock(UserLogin.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = employeeLoginController.loginEmployee(userLogin,session,modelMap);

		assertEquals(expected,actual);
		verify(userLogin, times(1)).setRole(EMPLOYEE_ROLE);
	}

	@Test
	void loginEmployeeError() throws UserAuthenticationException, InvalidRoleException {
		String expected = "employeelogin";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		UserLogin userLogin = Mockito.mock(UserLogin.class);

		Mockito.when(proxyLoginService.validateUser(userLogin)).thenThrow(new UserAuthenticationException("Invalid Role"));

		EmployeeLoginController employeeLoginController = new EmployeeLoginController(proxyLoginService);

		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = employeeLoginController.loginEmployee(userLogin,session,modelMap);
		verify(userLogin, times(1)).setRole(EMPLOYEE_ROLE);
		assertEquals(expected,actual);
	}

	@Test
	void logoutEmployee() {
		String expected = "redirect:/employeelogin";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		EmployeeLoginController employeeLoginController = new EmployeeLoginController(proxyLoginService);

		HttpSession session = Mockito.mock(HttpSession.class);
		Mockito.when(session.getAttribute("username")).thenReturn("user");
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = employeeLoginController.logoutEmployee( session, modelMap);

		assertEquals(expected,actual);
		verify(session, times(1)).invalidate();
		verify(session,times(1)).removeAttribute("role");

	}
}