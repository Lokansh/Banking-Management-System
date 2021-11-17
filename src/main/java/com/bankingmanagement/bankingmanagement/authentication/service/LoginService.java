package com.bankingmanagement.bankingmanagement.authentication.service;

import com.bankingmanagement.bankingmanagement.authentication.exception.userAuthenticationException;

public interface LoginService {

    boolean validateUser(String userid, String password) throws userAuthenticationException;

}
