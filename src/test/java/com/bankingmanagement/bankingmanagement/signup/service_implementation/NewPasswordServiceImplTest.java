package com.bankingmanagement.bankingmanagement.signup.service_implementation;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.signup.database.ForgetDao;
import com.bankingmanagement.bankingmanagement.signup.exception.NewPasswordException;
import com.bankingmanagement.bankingmanagement.signup.service.NewPasswordService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NewPasswordServiceImplTest {

	@Autowired
	NewPasswordService newPasswordService;

	@Test
	void saveNewPasswordError() {

		String expected = "Invalid format of password";
		String username="username";
		String password = "wrongpasswordformat";
		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		ForgetDao forgetDao = Mockito.mock(ForgetDao.class);

		NewPasswordServiceImpl newPasswordService = new NewPasswordServiceImpl(databaseConnectionDao,forgetDao);

		NewPasswordException actualException = assertThrows(
				NewPasswordException.class,
				() -> newPasswordService.saveNewPassword(username,password),
				"Expected to throw Error");
		assertEquals(expected,actualException.getErrorMessage());
	}

	@Test
	void saveNewPassword() throws NewPasswordException {
		String username="testblock";
		String password = "Admin@123";

		String actual = newPasswordService.saveNewPassword(username,password);

		assertEquals(username,actual);

	}
}