package com.bankingmanagement.bankingmanagement.signup.service_implementation;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.signup.database.ForgetDao;
import com.bankingmanagement.bankingmanagement.signup.exception.UserForgetPasswordException;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;
import com.bankingmanagement.bankingmanagement.signup.service.ForgetPasswordService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//Integration and Unit tests
@SpringBootTest
class ForgetPasswordServiceImplTest {

	@Autowired
	ForgetPasswordService forgetPasswordService;

	@Test
	void handleForgetPassword() throws UserForgetPasswordException {
		String expected = "manannnn";
		SecurityAnswer securityAnswer = new SecurityAnswer("manannnn",1,"dal");

		String actual = forgetPasswordService.handleForgetPassword(securityAnswer);
		assertEquals(expected,actual);
	}

	@Test
	void handleWrongForgetPassword() throws UserForgetPasswordException {
		String expected = "Security Answer is empty.";
		SecurityAnswer securityAnswer = new SecurityAnswer("manannnn",1,"");
		DatabaseConnectionDao databaseConnectionDao = Mockito.mock(DatabaseConnectionDao.class);
		ForgetDao forgetDao = Mockito.mock(ForgetDao.class);

		ForgetPasswordServiceImpl forgetPassword = new ForgetPasswordServiceImpl(databaseConnectionDao,forgetDao);

		UserForgetPasswordException actualException = assertThrows(
				UserForgetPasswordException.class,
				() -> forgetPassword.handleForgetPassword(securityAnswer),
				"Expected to throw Error");
		assertEquals(expected,actualException.getErrorMessage());
	}

}