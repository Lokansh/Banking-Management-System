package com.bankingmanagement.bankingmanagement.ccservice.model;


public class CreditCardInfo {
    private String customerID;
    private String cardNumber;
    private String cardType;
    private boolean cardStatus;
    private String cardLimit;
    private String cardCurrentLimit;
    private String cardCurrentOverdue;

    public CreditCardInfo(String customerID, String cardNumber, String cardType, boolean cardStatus, String cardLimit, String cardCurrentLimit, String cardCurrentOverdue) {
        this.customerID = customerID;
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.cardStatus = cardStatus;
        this.cardLimit = cardLimit;
        this.cardCurrentLimit = cardCurrentLimit;
        this.cardCurrentOverdue = cardCurrentOverdue;
    }

}
