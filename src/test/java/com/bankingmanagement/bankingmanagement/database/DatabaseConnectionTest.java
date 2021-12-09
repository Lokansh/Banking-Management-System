package com.bankingmanagement.bankingmanagement.database;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class DatabaseConnectionTest {

	private static DatabaseConnection databaseConnection;

	public DatabaseConnectionTest() {
		databaseConnection = DatabaseConnection.getInstance();
	}

	@Test
	void getConnection() {
		assertDoesNotThrow(() -> databaseConnection.getConnection(),
				"Error while getting connection");
	}

	@Test
	void closeConnection() {
		assertDoesNotThrow(() -> databaseConnection.closeConnection(),
				"Error while Closing connection");
	}
}