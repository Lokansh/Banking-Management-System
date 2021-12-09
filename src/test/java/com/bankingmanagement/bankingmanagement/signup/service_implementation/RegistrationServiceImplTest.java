package com.bankingmanagement.bankingmanagement.signup.service_implementation;

import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.signup.database.RegisterDao;
import com.bankingmanagement.bankingmanagement.signup.exception.UserRegistrationException;
import com.bankingmanagement.bankingmanagement.signup.model.Customer;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import com.bankingmanagement.bankingmanagement.signup.model.UserInfo;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RegistrationServiceImplTest {

	@Test
	void registerUserCustomerIDError() {

		String expectedError = "Invalid format of User ID";
		Customer customer = new Customer("","FirstName","LastName","Address1","Address2","halifax","12345","1234512345","mail@mail.com","123123123");
		SecurityAnswer securityAnswer = new SecurityAnswer("usertest",1,"halifax");
		UserLogin userLogin = new UserLogin("usertest","Admin@123","0");

		UserInfo user = new UserInfo(customer,securityAnswer,userLogin);

		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		RegisterDao registerDao = Mockito.mock(RegisterDao.class);

		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(databaseConnectionDao,registerDao);

		UserRegistrationException actualException = assertThrows(
				UserRegistrationException.class,
				() -> registrationService.registerUser(user),
				"Expected to throw Error");

		assertEquals(expectedError,actualException.getErrorMessage());
	}

	@Test
	void registerUserFirstNameError() {

		String expectedError = "FirstName is empty or Invalid ";
		Customer customer = new Customer("cusomer","123","LastName","Address1","Address2","halifax","12345","1234512345","mail@mail.com","123123123");
		SecurityAnswer securityAnswer = new SecurityAnswer("usertest",1,"halifax");
		UserLogin userLogin = new UserLogin("usertest","Admin@123","0");

		UserInfo user = new UserInfo(customer,securityAnswer,userLogin);

		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		RegisterDao registerDao = Mockito.mock(RegisterDao.class);

		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(databaseConnectionDao,registerDao);

		UserRegistrationException actualException = assertThrows(
				UserRegistrationException.class,
				() -> registrationService.registerUser(user),
				"Expected to throw Error");

		assertEquals(expectedError,actualException.getErrorMessage());
	}

	@Test
	void registerUserLastNameError() {

		String expectedError = "LastName is empty or Invalid ";
		Customer customer = new Customer("cusomer","firstNAme","","Address1","Address2","halifax","12345","1234512345","mail@mail.com","123123123");
		SecurityAnswer securityAnswer = new SecurityAnswer("usertest",1,"halifax");
		UserLogin userLogin = new UserLogin("usertest","Admin@123","0");

		UserInfo user = new UserInfo(customer,securityAnswer,userLogin);

		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		RegisterDao registerDao = Mockito.mock(RegisterDao.class);

		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(databaseConnectionDao,registerDao);

		UserRegistrationException actualException = assertThrows(
				UserRegistrationException.class,
				() -> registrationService.registerUser(user),
				"Expected to throw Error");

		assertEquals(expectedError,actualException.getErrorMessage());
	}

	@Test
	void registerUserAddressError() {

		String expectedError = "Address2 is empty ";
		Customer customer = new Customer("cusomer","firstName","lastName","Address1","","halifax","12345","1234512345","mail@mail.com","123123123");
		SecurityAnswer securityAnswer = new SecurityAnswer("usertest",1,"halifax");
		UserLogin userLogin = new UserLogin("usertest","Admin@123","0");

		UserInfo user = new UserInfo(customer,securityAnswer,userLogin);

		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		RegisterDao registerDao = Mockito.mock(RegisterDao.class);

		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(databaseConnectionDao,registerDao);

		UserRegistrationException actualException = assertThrows(
				UserRegistrationException.class,
				() -> registrationService.registerUser(user),
				"Expected to throw Error");

		assertEquals(expectedError,actualException.getErrorMessage());
	}

	@Test
	void registerZipCodeError() {

		String expectedError = "Zipcode is empty or Invalid";
		Customer customer = new Customer("cusomer","firstName","lastName","Address1","address2","halifax","abc123","1234512345","mail@mail.com","123123123");
		SecurityAnswer securityAnswer = new SecurityAnswer("usertest",1,"halifax");
		UserLogin userLogin = new UserLogin("usertest","Admin@123","0");

		UserInfo user = new UserInfo(customer,securityAnswer,userLogin);

		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		RegisterDao registerDao = Mockito.mock(RegisterDao.class);

		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(databaseConnectionDao,registerDao);

		UserRegistrationException actualException = assertThrows(
				UserRegistrationException.class,
				() -> registrationService.registerUser(user),
				"Expected to throw Error");

		assertEquals(expectedError,actualException.getErrorMessage().trim());
	}

	@Test
	void registerContactError() {

		String expectedError = "ContactNumber is empty";
		Customer customer = new Customer("cusomer","firstName","lastName","Address1","address2","halifax","12345","","mail@mail.com","123123123");
		SecurityAnswer securityAnswer = new SecurityAnswer("usertest",1,"halifax");
		UserLogin userLogin = new UserLogin("usertest","Admin@123","0");

		UserInfo user = new UserInfo(customer,securityAnswer,userLogin);

		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		RegisterDao registerDao = Mockito.mock(RegisterDao.class);

		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(databaseConnectionDao,registerDao);

		UserRegistrationException actualException = assertThrows(
				UserRegistrationException.class,
				() -> registrationService.registerUser(user),
				"Expected to throw Error");

		assertEquals(expectedError,actualException.getErrorMessage().trim());
	}

	@Test
	void registerWrongEmailError() {

		String expectedError = "Email is empty or Invalid";
		Customer customer = new Customer("cusomer","firstName","lastName","Address1","address2","halifax","12345","1234512345","wrongmail","123123123");
		SecurityAnswer securityAnswer = new SecurityAnswer("usertest",1,"halifax");
		UserLogin userLogin = new UserLogin("usertest","Admin@123","0");

		UserInfo user = new UserInfo(customer,securityAnswer,userLogin);

		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		RegisterDao registerDao = Mockito.mock(RegisterDao.class);

		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(databaseConnectionDao,registerDao);

		UserRegistrationException actualException = assertThrows(
				UserRegistrationException.class,
				() -> registrationService.registerUser(user),
				"Expected to throw Error");

		assertEquals(expectedError,actualException.getErrorMessage().trim());
	}

	@Test
	void registerWrongSINError() {

		String expectedError = "sin is empty or Invalid";
		Customer customer = new Customer("cusomer","firstName","lastName","Address1","address2","halifax","12345","1234512345","mail@mail.com","123123");
		SecurityAnswer securityAnswer = new SecurityAnswer("usertest",1,"halifax");
		UserLogin userLogin = new UserLogin("usertest","Admin@123","0");

		UserInfo user = new UserInfo(customer,securityAnswer,userLogin);

		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		RegisterDao registerDao = Mockito.mock(RegisterDao.class);

		RegistrationServiceImpl registrationService = new RegistrationServiceImpl(databaseConnectionDao,registerDao);

		UserRegistrationException actualException = assertThrows(
				UserRegistrationException.class,
				() -> registrationService.registerUser(user),
				"Expected to throw Error");

		assertEquals(expectedError,actualException.getErrorMessage().trim());
	}
}