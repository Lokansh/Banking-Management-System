package com.bankingmanagement.bankingmanagement.signup.service;

import com.bankingmanagement.bankingmanagement.signup.exception.NewPasswordException;

public interface NewPasswordService {
    String saveNewPassword(String username,String password) throws NewPasswordException;

}
