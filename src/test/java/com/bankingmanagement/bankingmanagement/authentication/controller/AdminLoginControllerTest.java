package com.bankingmanagement.bankingmanagement.authentication.controller;

import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.authentication.service_implementation.ProxyLoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.ADMIN_ROLE;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class AdminLoginControllerTest {

	@Test
	void getLogin() {
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		String expected = "adminlogin";
		AdminLoginController adminLoginController = new AdminLoginController(proxyLoginService);

		String actual = adminLoginController.getLogin();
		assertEquals(expected,actual);
	}

	@Test
	void loginAdmin() {
		String expected = "redirect:/admin";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);

		AdminLoginController adminLoginController = new AdminLoginController(proxyLoginService);

		UserLogin userLogin = Mockito.mock(UserLogin.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = adminLoginController.loginAdmin(userLogin,session,modelMap);

		assertEquals(expected,actual);
		verify(userLogin, times(1)).setRole(ADMIN_ROLE);

	}

	@Test
	void loginAdminError() throws UserAuthenticationException, InvalidRoleException {
		String expected = "adminlogin";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		UserLogin userLogin = Mockito.mock(UserLogin.class);

		Mockito.when(proxyLoginService.validateUser(userLogin)).thenThrow(new UserAuthenticationException("Invalid Role"));

		AdminLoginController adminLoginController = new AdminLoginController(proxyLoginService);

		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = adminLoginController.loginAdmin(userLogin,session,modelMap);
		verify(userLogin, times(1)).setRole(ADMIN_ROLE);
		assertEquals(expected,actual);
	}

	@Test
	void logoutAdmin() {
		String expected = "redirect:/adminlogin";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		AdminLoginController adminLoginController = new AdminLoginController(proxyLoginService);

		HttpSession session = Mockito.mock(HttpSession.class);
		Mockito.when(session.getAttribute("username")).thenReturn("user");
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = adminLoginController.logoutAdmin( session, modelMap);

		assertEquals(expected,actual);
		verify(session, times(1)).invalidate();
		verify(session,times(1)).removeAttribute("role");

	}
}