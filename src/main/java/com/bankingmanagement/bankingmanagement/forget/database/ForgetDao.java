package com.bankingmanagement.bankingmanagement.forget.database;

public interface ForgetDao {
    
    String getSecurityQuestionQuery(String username);
    String updatePasswordQuery(String username,String password);
}
