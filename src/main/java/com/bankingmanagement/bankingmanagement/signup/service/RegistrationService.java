package com.bankingmanagement.bankingmanagement.signup.service;

import com.bankingmanagement.bankingmanagement.signup.exception.UserRegistrationException;
import com.bankingmanagement.bankingmanagement.signup.model.UserInfo;

public interface RegistrationService {

    String registerUser(UserInfo userInfo) throws UserRegistrationException;

}
