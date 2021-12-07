package com.bankingmanagement.bankingmanagement.authentication.database;

public interface LoginDao {
    String  selectUserByUsername(String username);
}
