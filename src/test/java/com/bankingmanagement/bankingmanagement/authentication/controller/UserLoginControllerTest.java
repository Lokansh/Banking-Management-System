package com.bankingmanagement.bankingmanagement.authentication.controller;

import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.authentication.service_implementation.ProxyLoginServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.USER_ROLE;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class UserLoginControllerTest {

	@Test
	void getLogin(){
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		String expected = "login";
		UserLoginController userLoginController = new UserLoginController(proxyLoginService);

		String actual = userLoginController.getLogin();
		assertEquals(expected,actual);
	}

	@Test
	void getProfile(){
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		String expected = "user";
		UserLoginController userLoginController = new UserLoginController(proxyLoginService);

		String actual = userLoginController.getProfile();
		assertEquals(expected,actual);
	}

	@Test
	public void loginUser()
	{
		String expected = "redirect:/user";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);

		UserLoginController userLoginController = new UserLoginController(proxyLoginService);

		UserLogin userLogin = Mockito.mock(UserLogin.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = userLoginController.loginUser(userLogin,session,modelMap);

		assertEquals(expected,actual);
		verify(userLogin, times(1)).setRole(USER_ROLE);

	}

	@Test
	public void loginUserError() throws UserAuthenticationException, InvalidRoleException {
		String expected = "login";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		UserLogin userLogin = Mockito.mock(UserLogin.class);

		Mockito.when(proxyLoginService.validateUser(userLogin)).thenThrow(new UserAuthenticationException("Invalid User"));

		UserLoginController userLoginController = new UserLoginController(proxyLoginService);

		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = userLoginController.loginUser(userLogin,session,modelMap);
		verify(userLogin, times(1)).setRole(USER_ROLE);
		assertEquals(expected,actual);
	}

	@Test
	public void logoutUser(){

		String expected = "redirect:/login";
		ProxyLoginServiceImpl proxyLoginService = Mockito.mock(ProxyLoginServiceImpl.class);
		UserLoginController userLoginController = new UserLoginController(proxyLoginService);

		HttpSession session = Mockito.mock(HttpSession.class);
		Mockito.when(session.getAttribute("username")).thenReturn("user");
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		String actual = userLoginController.logoutUser( session, modelMap);

		assertEquals(expected,actual);
		verify(session, times(1)).invalidate();
		verify(session,times(1)).removeAttribute("role");

	}


}
