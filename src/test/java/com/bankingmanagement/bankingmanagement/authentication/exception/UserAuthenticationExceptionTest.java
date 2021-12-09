package com.bankingmanagement.bankingmanagement.authentication.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserAuthenticationExceptionTest {

	@Test
	void getMessage() {
		UserAuthenticationException userAuthenticationException = new UserAuthenticationException("Invalid user");

		assertEquals("Invalid user",userAuthenticationException.getMessage());
		assertEquals("userAuthenticationException{errorMessage='Invalid user'}",userAuthenticationException.toString());

	}
}