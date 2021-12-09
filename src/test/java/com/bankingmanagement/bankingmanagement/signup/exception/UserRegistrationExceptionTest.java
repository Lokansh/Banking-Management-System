package com.bankingmanagement.bankingmanagement.signup.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRegistrationExceptionTest {

	private UserRegistrationException userRegistrationException;

	public UserRegistrationExceptionTest() {
		userRegistrationException = new UserRegistrationException("Invalid user");
	}

	@Test
	void getErrorMessage() {
		assertEquals("Invalid user",userRegistrationException.getErrorMessage());
	}

	@Test
	void testToString() {
		assertEquals("UserRegistrationException{errorMessage='Invalid user'}",userRegistrationException.toString());

	}
}