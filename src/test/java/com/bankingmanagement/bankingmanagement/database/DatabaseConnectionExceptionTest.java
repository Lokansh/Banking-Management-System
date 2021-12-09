package com.bankingmanagement.bankingmanagement.database;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DatabaseConnectionExceptionTest {

	private DatabaseConnectionException databaseConnectionException;

	public DatabaseConnectionExceptionTest() {
		databaseConnectionException = new DatabaseConnectionException("Invalid credentials",new Exception("Error"));
	}

	@Test
	void getMessage() {
		assertEquals("Invalid credentials",databaseConnectionException.getMessage());
	}

	@Test
	void testToString() {
		assertEquals("DatabaseConnectionException{errMsg='Invalid credentials', error=java.lang.Exception: Error}",databaseConnectionException.toString());
	}
}