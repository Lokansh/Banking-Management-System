package com.bankingmanagement.bankingmanagement.forget.service;

import com.bankingmanagement.bankingmanagement.forget.exception.UserForgetPasswordException;
import com.bankingmanagement.bankingmanagement.signup.model.SecurityAnswer;

public interface ForgetPasswordService {

    String handleForgetPassword(SecurityAnswer securityAnswer) throws UserForgetPasswordException;

}
