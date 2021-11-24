package com.bankingmanagement.bankingmanagement.authentication.model;


public class UserLogin {

    private String UserLoginID;
    private String password;

    public UserLogin(String userLoginID, String password) {
        UserLoginID = userLoginID;
        this.password = password;
    }

    public String getUserLoginID() {
        return UserLoginID;
    }

    public void setUserLoginID(String userLoginID) {
        UserLoginID = userLoginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
