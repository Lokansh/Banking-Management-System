package com.bankingmanagement.bankingmanagement.ccservice.model;


public class CreditCardInfo {
    private String customerID;
    private String cardNumber;
    private String cardType;
    private boolean cardStatus;
    private String cardLimit;

    public CreditCardInfo(String customerID, String cardNumber, String cardType, boolean cardStatus, String cardLimit) {
        this.customerID = customerID;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardStatus = cardStatus;
        this.cardLimit = cardLimit;
    }

    public String getCustomerID() {
        return customerID;
    }

    public void setCustomerID(String customerID) {
        this.customerID = customerID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public boolean getCardStatus() {
        return cardStatus;
    }

    public void setCardStatus(boolean cardStatus) {
        this.cardStatus = cardStatus;
    }

    public String getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(String cardLimit) {
        this.cardLimit = cardLimit;
    }
}
