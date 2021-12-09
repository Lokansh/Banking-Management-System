package com.bankingmanagement.bankingmanagement.authentication.exception;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InvalidRoleExceptionTest {

	@Test
	void getMessage() {
		InvalidRoleException invalidRoleException = new InvalidRoleException("Invalid Role");

		assertEquals("Invalid Role",invalidRoleException.getMessage());
		assertEquals("InvalidRoleException{errorMessage='Invalid Role'}",invalidRoleException.toString());

		System.out.println(invalidRoleException.toString());

	}
}