package com.bankingmanagement.bankingmanagement.signup.database;

public interface ForgetDao {
    
    String getSecurityQuestionQuery(String username);
    String updatePasswordQuery(String username,String password);
}
