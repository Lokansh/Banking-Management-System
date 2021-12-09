package com.bankingmanagement.bankingmanagement.authentication.database;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LoginDaoImplTest {

	@Test
	void selectUserByUsername() {
		LoginDao loginDao = new LoginDaoImpl();

		String username = "testUser";
		String expected = "SELECT CustomerID, FailedAttempt, Password, RoleType, BlockTimeStamp FROM User_Login WHERE CustomerID=\"testUser\";";

		String actual = loginDao.selectUserByUsername(username);
		assertEquals(expected,actual);

	}

	@Test
	void storeDatetimeQuery() {
		LoginDao loginDao = new LoginDaoImpl();

		String username = "username";
		String datetime = "2020-01-01 00:00:00";
		String expected = "UPDATE User_Login SET BlockTimeStamp =\"2020-01-01 00:00:00\",FailedAttempt =\"0\"  WHERE CustomerID=\"username\";";

		String actual = loginDao.storeDatetimeQuery(username,datetime);
		assertEquals(expected,actual);
	}

	@Test
	void storeFailedAttemptQuery() {
		LoginDao loginDao = new LoginDaoImpl();

		String username = "testUser";
		int failedAttempt = 2;
		String expected = "UPDATE User_Login SET FailedAttempt =\"2\"  WHERE CustomerID=\"testUser\";";
		String actual = loginDao.storeFailedAttemptQuery(username,failedAttempt);
		assertEquals(expected,actual);
	}
}