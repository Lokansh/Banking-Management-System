package com.bankingmanagement.bankingmanagement.signup.database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ForgetDaoImplTest {

	@Test
	void getSecurityQuestionQuery() {
		String username = "testUser";
		String expected = "SELECT CustomerID, SecurityQuestionID, SecurityAnswer FROM User_Security_Answer WHERE CustomerID=\"testUser\";";
		ForgetDao forgetDao = new ForgetDaoImpl();

		String actual = forgetDao.getSecurityQuestionQuery(username);
		Assertions.assertEquals(expected,actual);
	}

	@Test
	void updatePasswordQuery() {
		String username = "testUsername";
		String password = "password";
		String expected = "UPDATE User_Login SET Password =\"password\" ,FailedAttempt =\"0\" ,BlockTimeStamp =\"2020-01-01 00:00:00\"  WHERE CustomerID=\"testUsername\";";
		ForgetDao forgetDao = new ForgetDaoImpl();

		String actual = forgetDao.updatePasswordQuery(username,password);
		Assertions.assertEquals(expected,actual);	}
}