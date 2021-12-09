package com.bankingmanagement.bankingmanagement.signup.database;

import com.bankingmanagement.bankingmanagement.signup.model.Customer;

public interface RegisterDao {
    String insertUserTableQuery(Customer customer);
    String insertLoginTableQuery(String username,String password);
    String insertSecurityQuestionTableQuery(String userID,int Qid,String answer);
}
