package com.bankingmanagement.bankingmanagement.card.model;

public class CreditScore {
    private String customerID;
    private String sin;
    private String creditScore;
    private String lastUpdate;

    public CreditScore() {}

    public CreditScore(String customerID, String sin, String creditScore, String lastUpdate) {
        this.customerID = customerID;
        this.sin = sin;
        this.creditScore = creditScore;
        this.lastUpdate = lastUpdate;
    }

    public String getCustomerID() {
        return customerID;
    }
    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getSin() {
        return sin;
    }
    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getCreditScore() {
        return creditScore;
    }
    public void setCreditScore(String creditScore) {
        this.creditScore = creditScore;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(String lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
}
