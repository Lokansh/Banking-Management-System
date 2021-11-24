package com.bankingmanagement.bankingmanagement.forget.service;

import com.bankingmanagement.bankingmanagement.forget.exception.NewPasswordException;

public interface NewPasswordService {
    String saveNewPassword(String username,String password) throws NewPasswordException;

}
