package com.bankingmanagement.bankingmanagement.signup.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserForgetPasswordExceptionTest {
	private UserForgetPasswordException userForgetPasswordException;

	public UserForgetPasswordExceptionTest() {
		userForgetPasswordException = new UserForgetPasswordException("Wrong Security Answer");

	}

	@Test
	void getErrorMessage() {
		assertEquals("Wrong Security Answer",userForgetPasswordException.getErrorMessage());

	}

	@Test
	void testToString() {
		assertEquals("UserForgetPasswordException{errorMessage='Wrong Security Answer'}",userForgetPasswordException.toString());

	}
}