package com.bankingmanagement.bankingmanagement.signup.controller;

import com.bankingmanagement.bankingmanagement.signup.model.User;
import com.bankingmanagement.bankingmanagement.signup.service.RegistrationService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UserRegistrationControllerTest {

	@Test
	void getSignup() {
		String expected = "register";

		RegistrationService registrationService = Mockito.mock(RegistrationService.class);

		UserRegistrationController userRegistrationController = new UserRegistrationController(registrationService);

		String actual =userRegistrationController.getSignup();

		assertEquals(expected,actual);
	}

	@Test
	void registerUser() {
		String expected = "redirect:user";

		User user = Mockito.mock(User.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		RegistrationService registrationService = Mockito.mock(RegistrationService.class);

		UserRegistrationController userRegistrationController = new UserRegistrationController(registrationService);

		Mockito.when(session.getAttribute("username")).thenReturn("user");

		String actual =userRegistrationController.registerUser(user,session,modelMap);

		verify(session, times(1)).setAttribute("role","user");

		assertEquals(expected,actual);
	}

}