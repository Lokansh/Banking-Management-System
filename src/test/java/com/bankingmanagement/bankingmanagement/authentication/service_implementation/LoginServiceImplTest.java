package com.bankingmanagement.bankingmanagement.authentication.service_implementation;

import com.bankingmanagement.bankingmanagement.authentication.database.LoginDao;
import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.ADMIN_ROLE;
import static com.bankingmanagement.bankingmanagement.authentication.database.LoginConstants.USER_ROLE;
import static org.junit.jupiter.api.Assertions.*;

// unit test and integration test with database

@SpringBootTest
class LoginServiceImplTest {

	@Autowired
	LoginServiceImpl loginService;

	@Test
	void validateWrongPasswordFormat() {

		String expected = "Invalid format of email and/or password";

		UserLogin userLogin = Mockito.mock(UserLogin.class);
		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		LoginDao loginDao = Mockito.mock(LoginDao.class);

		Mockito.when(userLogin.getUserLoginID()).thenReturn("username");
		Mockito.when(userLogin.getPassword()).thenReturn("password");
		Mockito.when(userLogin.getRole()).thenReturn("role");

		LoginServiceImpl loginService =new LoginServiceImpl(databaseConnectionDao,loginDao);

		UserAuthenticationException actualException = assertThrows(
				UserAuthenticationException.class,
				() -> loginService.validateUser(userLogin),
				"Expected to throw Error");

		assertEquals(expected,actualException.getMessage());

	}

	// integration testing with database
	@Test
	void validateUser() throws UserAuthenticationException, InvalidRoleException {
		boolean expected = true;
		UserLogin userLogin = new UserLogin("testvalid","Admin@123", USER_ROLE);

		boolean actual = loginService.validateUser(userLogin);
		assertEquals(expected,actual);
	}

	@Test
	void validateInvalidUser() {
		String expected = "Invalid username and/or password";
		UserLogin userLogin = new UserLogin("dummyFakeUser","Admin@123", USER_ROLE);

		UserAuthenticationException actualException = assertThrows(
				UserAuthenticationException.class,
				() -> loginService.validateUser(userLogin),
				"Expected to throw Error");
		assertEquals(expected,actualException.getMessage());

	}
	
	@Test
	void blockAccountTest(){
		String expected = "Username blocked";

		int count=0;
		UserLogin userLogin = new UserLogin("testblock","FakePassword@123", USER_ROLE);
		
		UserAuthenticationException actualException = null;
		while(count<3){
			actualException = assertThrows(
					UserAuthenticationException.class,
					() -> loginService.validateUser(userLogin),
					"Expected to throw Error");
			count+=1;
		}
		assertTrue(actualException.getMessage().contains(expected));
	}

	@Test
	void invalidRoleTest(){
		String expected = "Role does not have access to this page.";

		int count=0;
		UserLogin userLogin = new UserLogin("testvalid","FakePassword@123", ADMIN_ROLE);

		InvalidRoleException actualException = assertThrows(
				InvalidRoleException.class,
				() -> loginService.validateUser(userLogin),
				"Expected to throw Error");
		assertEquals(expected,actualException.getMessage());
	}

	@Test
	void logout() throws UserAuthenticationException {
		String username = "user";
		UserLogin userLogin = Mockito.mock(UserLogin.class);
		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		LoginDao loginDao = Mockito.mock(LoginDao.class);

		LoginServiceImpl loginService =new LoginServiceImpl(databaseConnectionDao,loginDao);

		assertDoesNotThrow(() -> loginService.logout(username),
				"Exception Not expected while logging out validation");
	}
}