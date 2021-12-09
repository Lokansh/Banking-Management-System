package com.bankingmanagement.bankingmanagement.fundManipulation.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

class FundManipulationTest {

	@Test
	public void fundManipulationClassExists() throws ClassNotFoundException {
		// checking whether the class exists or not
		assertNotNull(
				Class.forName("com.bankingmanagement.bankingmanagement.fundManipulation.controller.FundManipulation"));
	}

	FundManipulation testObject = new FundManipulation();

	@Test
	void testCustHome() {
		assertEquals("customerHome", testObject.custHome());
	}

}
