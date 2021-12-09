package com.bankingmanagement.bankingmanagement.signup.model;

import com.bankingmanagement.bankingmanagement.authentication.model.UserLogin;

public class UserInfo {

    private Customer customer;
    private SecurityAnswer securityAnswer;
    private UserLogin userLogin;

    public UserInfo(Customer customer, SecurityAnswer securityAnswer, UserLogin userLogin) {
        this.customer = customer;
        this.securityAnswer = securityAnswer;
        this.userLogin = userLogin;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer user) {
        this.customer = user;
    }

    public SecurityAnswer getSecurityAnswer() {
        return securityAnswer;
    }

    public void setSecurityAnswer(SecurityAnswer securityAnswer) {
        this.securityAnswer = securityAnswer;
    }

    public UserLogin getUserLogin() {
        return userLogin;
    }

    public void setUserLogin(UserLogin userLogin) {
        this.userLogin = userLogin;
    }
}
