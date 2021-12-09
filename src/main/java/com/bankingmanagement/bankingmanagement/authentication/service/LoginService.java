package com.bankingmanagement.bankingmanagement.authentication.service;

import com.bankingmanagement.bankingmanagement.authentication.exception.InvalidRoleException;
import com.bankingmanagement.bankingmanagement.authentication.exception.UserAuthenticationException;
import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;

public interface LoginService {

    boolean validateUser(UserLogin userLogin) throws UserAuthenticationException, InvalidRoleException;

	void logout(String username) throws UserAuthenticationException;
}
