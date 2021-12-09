package com.bankingmanagement.bankingmanagement.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HashAlgorithmTest {

	@Test
	void validateSHA256Hash() {
		String password = "Admin@123";
		String expectedHash = "e86f78a8a3caf0b60d8e74e5942aa6d86dc150cd3c03338aef25b7d2d7e3acc7";
		assertTrue(	HashAlgorithm.validateSHA256Hash(password,expectedHash));
	}

	@Test
	void getSHA256Hash() {
		String password = "Admin@123";
		String expectedHash = "e86f78a8a3caf0b60d8e74e5942aa6d86dc150cd3c03338aef25b7d2d7e3acc7";
		String passwordSHA256Hash = HashAlgorithm.getSHA256Hash(password);
		assertEquals(expectedHash,passwordSHA256Hash);
	}
}