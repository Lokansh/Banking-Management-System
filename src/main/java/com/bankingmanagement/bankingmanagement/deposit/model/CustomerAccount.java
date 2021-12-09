package com.bankingmanagement.bankingmanagement.deposit.model;

public class CustomerAccount {

    private String customerId;
    private String accountId;
    private String balance;

    @Override
    public String toString() {
        return "CustomerAccount{" +
                "customerId='" + customerId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    public CustomerAccount(String customerId, String accountId, String balance) {
        this.customerId = customerId;
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

}
