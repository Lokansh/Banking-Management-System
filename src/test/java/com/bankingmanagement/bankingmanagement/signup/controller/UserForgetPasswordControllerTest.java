package com.bankingmanagement.bankingmanagement.signup.controller;

import com.bankingmanagement.bankingmanagement.signup.exception.NewPasswordException;
import com.bankingmanagement.bankingmanagement.signup.exception.UserForgetPasswordException;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import com.bankingmanagement.bankingmanagement.signup.service.ForgetPasswordService;
import com.bankingmanagement.bankingmanagement.signup.service.NewPasswordService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class UserForgetPasswordControllerTest {

	@Test
	void forgetPassword() {
		ForgetPasswordService forgetPasswordService = Mockito.mock(ForgetPasswordService.class);
		NewPasswordService newPasswordService = Mockito.mock(NewPasswordService.class);
		String expected = "forget";
		UserForgetPasswordController userForgetPasswordController = new UserForgetPasswordController(forgetPasswordService,newPasswordService);

		String actual = userForgetPasswordController.forgetPassword();
		assertEquals(expected,actual);

	}

	@Test
	void newPassword() {
		String expected = "newpassword";
		ForgetPasswordService forgetPasswordService = Mockito.mock(ForgetPasswordService.class);
		NewPasswordService newPasswordService = Mockito.mock(NewPasswordService.class);
		UserForgetPasswordController userForgetPasswordController = new UserForgetPasswordController(forgetPasswordService,newPasswordService);

		String actual = userForgetPasswordController.newPassword();
		assertEquals(expected,actual);
	}

	@Test
	void updatePassword() throws NewPasswordException {
		String expected = "redirect:user";

		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);
		String password = "password";

		ForgetPasswordService forgetPasswordService = Mockito.mock(ForgetPasswordService.class);
		NewPasswordService newPasswordService = Mockito.mock(NewPasswordService.class);
		UserForgetPasswordController userForgetPasswordController = new UserForgetPasswordController(forgetPasswordService,newPasswordService);

		Mockito.when(session.getAttribute("username")).thenReturn("user");
		Mockito.when(newPasswordService.saveNewPassword("user","password")).thenReturn("userSet");

		String actual =userForgetPasswordController.updatePassword(password,session,modelMap);

		verify(session, times(1)).setAttribute("username","userSet");
		verify(session,times(1)).removeAttribute("new_password");
		assertEquals(expected,actual);

	}

	@Test
	void updatePasswordError() throws NewPasswordException {
		String expected = "newpassword";

		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);
		String password = "password";

		ForgetPasswordService forgetPasswordService = Mockito.mock(ForgetPasswordService.class);
		NewPasswordService newPasswordService = Mockito.mock(NewPasswordService.class);
		UserForgetPasswordController userForgetPasswordController = new UserForgetPasswordController(forgetPasswordService,newPasswordService);

		Mockito.when(session.getAttribute("username")).thenReturn("user");
		Mockito.when(newPasswordService.saveNewPassword("user","password")).thenReturn("userTest");

		Mockito.when(newPasswordService.saveNewPassword("user","password")).thenThrow(new NewPasswordException("Invalid Password"));

		String actual =userForgetPasswordController.updatePassword(password,session,modelMap);

		verify(modelMap, times(1)).put("errorMsg","Invalid Password");
		verify(session,times(0)).removeAttribute("new_password");
		assertEquals(expected,actual);

	}

	@Test
	void changePassword() throws UserForgetPasswordException {

		String expected = "redirect:newpassword";

		SecurityAnswer securityAnswer = Mockito.mock(SecurityAnswer.class);
		HttpSession session = Mockito.mock(HttpSession.class);
		ModelMap modelMap = Mockito.mock(ModelMap.class);

		ForgetPasswordService forgetPasswordService = Mockito.mock(ForgetPasswordService.class);
		NewPasswordService newPasswordService = Mockito.mock(NewPasswordService.class);

		UserForgetPasswordController userForgetPasswordController = new UserForgetPasswordController(forgetPasswordService,newPasswordService);

		Mockito.when(session.getAttribute("username")).thenReturn("user");
		Mockito.when(forgetPasswordService.handleForgetPassword(securityAnswer)).thenReturn("user");

		String actual =userForgetPasswordController.changePassword(securityAnswer,session,modelMap);

		verify(session, times(1)).setAttribute("username","user");
		verify(session,times(1)).setAttribute("new_password",true);

		assertEquals(expected,actual);
	}

}