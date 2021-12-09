package com.bankingmanagement.bankingmanagement.signup.database;

import com.bankingmanagement.bankingmanagement.signup.model.Customer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RegisterDaoImplTest {

	@Test
	void insertUserTableQuery() {

		RegisterDao registerDao = new RegisterDaoImpl();
		Customer customer = new Customer("test","firstName","lastName","address1","address2","city","123456","1234567890","test@mail.com","123456");

		String expected = "INSERT INTO Customer(CustomerID, FirstName, LastName, Address1, Address2, City, Email, Zipcode, PhoneNumber, SocialInsuranceNumber) VALUES (\"test\", \"firstName\", \"lastName\", \"address1\", \"address2\", \"city\", \"test@mail.com\", \"123456\", \"1234567890\", \"123456\");";

		String actual = registerDao.insertUserTableQuery(customer);
		Assertions.assertEquals(expected,actual);

	}

	@Test
	void insertLoginTableQuery() {

		RegisterDao registerDao = new RegisterDaoImpl();

		String username="testUser";
		String password="password";
		String expected = "INSERT INTO User_Login(CustomerID, FailedAttempt, RoleType, Password) VALUES (\"testUser\", \"0\", \"0\", \"password\" );";

		String actual =registerDao.insertLoginTableQuery(username,password);
		Assertions.assertEquals(expected,actual);
	}

	@Test
	void insertSecurityQuestionTableQuery() {

		RegisterDao registerDao = new RegisterDaoImpl();

		String userID = "test";
		int questionID = 1;
		String answer = "answer";
		String expected = "INSERT INTO User_Security_Answer(CustomerID, SecurityQuestionID, SecurityAnswer) VALUES (\"test\", \"1\", \"answer\" );";

		String actual = registerDao.insertSecurityQuestionTableQuery(userID,questionID,answer);
		Assertions.assertEquals(expected,actual);
	}
}