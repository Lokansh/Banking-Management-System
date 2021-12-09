package com.bankingmanagement.bankingmanagement.authentication.model;

public class UserLogin {

    private final String userLoginID;
    private String password;
    private String role;

    public UserLogin(String userLoginID, String password, String role) {
        this.userLoginID = userLoginID;
        this.password = password;
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUserLoginID() {
        return userLoginID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
