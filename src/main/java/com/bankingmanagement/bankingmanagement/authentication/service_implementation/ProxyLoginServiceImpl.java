package com.bankingmanagement.bankingmanagement.authentication.service_implementation;

import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;
import com.bankingmanagement.bankingmanagement.authentication.service.LoginService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashSet;

@Service("proxyLoginService")
public class ProxyLoginServiceImpl implements LoginService {

	private final HashSet<String> users;
	private final LoginService loginService;

	public ProxyLoginServiceImpl(@Qualifier("loginService") LoginService loginService) {
		this.loginService = loginService;
		users= new HashSet<>();
	}

	@Override
	public boolean validateUser(UserLogin userLogin) throws UserAuthenticationException, InvalidRoleException {

		String username = userLogin.getUserLoginID();

		if(users.contains(username)){
			throw new UserAuthenticationException("User Already Logged in Another Device");
		}
		loginService.validateUser(userLogin);
		this.addUser(username);
		return true;
	}

	public void addUser(String user){
		users.add(user);
	}

	public void removeUser(String user){
		users.remove(user);
	}

	public void logout(String username) throws UserAuthenticationException {
		loginService.logout(username);
		this.removeUser(username);
	}

}
