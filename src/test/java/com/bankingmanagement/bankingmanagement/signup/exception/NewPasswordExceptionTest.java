package com.bankingmanagement.bankingmanagement.signup.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewPasswordExceptionTest {
	private NewPasswordException newPasswordException;

	public NewPasswordExceptionTest() {
		this.newPasswordException = new NewPasswordException("Wrong password format");;
	}

	@Test
	void getErrorMessage() {

		assertEquals("Wrong password format",newPasswordException.getErrorMessage());
	}

	@Test
	void testToString() {
		assertEquals("NewPasswordException{errorMessage='Wrong password format'}",newPasswordException.toString());

	}
}