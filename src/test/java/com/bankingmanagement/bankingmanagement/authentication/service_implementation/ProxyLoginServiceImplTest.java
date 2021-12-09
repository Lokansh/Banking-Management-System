package com.bankingmanagement.bankingmanagement.authentication.service_implementation;

import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;

class ProxyLoginServiceImplTest {

	@Test
	void validateUser() throws UserAuthenticationException, InvalidRoleException {

		boolean expected = true;

		LoginServiceImpl loginService = Mockito.mock(LoginServiceImpl.class);
		UserLogin userLogin = Mockito.mock(UserLogin.class);

		Mockito.when(loginService.validateUser(userLogin)).thenReturn(true);
		Mockito.when(userLogin.getUserLoginID()).thenReturn("user");

		ProxyLoginServiceImpl proxyLoginService = new ProxyLoginServiceImpl(loginService);

		boolean actual = proxyLoginService.validateUser(userLogin);
		assertEquals(expected,actual);
	}

	@Test
	void existingLoggedUser() throws UserAuthenticationException, InvalidRoleException {
		String expected = "User Already Logged in Another Device";
		LoginServiceImpl loginService = Mockito.mock(LoginServiceImpl.class);

		UserLogin userLogin = Mockito.mock(UserLogin.class);
		Mockito.when(userLogin.getUserLoginID()).thenReturn("user");

		Mockito.when(loginService.validateUser(userLogin)).thenReturn(true);

		ProxyLoginServiceImpl proxyLoginService = new ProxyLoginServiceImpl(loginService);
		proxyLoginService.addUser("user");

		UserAuthenticationException actualException = assertThrows(
				UserAuthenticationException.class,
				() -> proxyLoginService.validateUser(userLogin),
				"Expected to throw Error");

		assertEquals(expected,actualException.getMessage());
	}

	@Test
	void logout() {
		LoginServiceImpl loginService = Mockito.mock(LoginServiceImpl.class);
		ProxyLoginServiceImpl proxyLoginService = new ProxyLoginServiceImpl(loginService);
		proxyLoginService.addUser("dummyUser");
		String username = "dummyUser";

		assertDoesNotThrow(() -> proxyLoginService.logout(username),
				"Error while Logging out");

	}
}