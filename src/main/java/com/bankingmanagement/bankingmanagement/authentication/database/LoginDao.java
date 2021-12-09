package com.bankingmanagement.bankingmanagement.authentication.database;

public interface LoginDao {
    String selectUserByUsername(String username);
    String storeDatetimeQuery(String username,String datetime);
    String storeFailedAttemptQuery(String username, int failedAttempt);
}
