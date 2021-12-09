package com.bankingmanagement.bankingmanagement.signup.service;

import com.bankingmanagement.bankingmanagement.signup.exception.UserForgetPasswordException;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;

public interface ForgetPasswordService {

    String handleForgetPassword(SecurityAnswer securityAnswer) throws UserForgetPasswordException;

}
