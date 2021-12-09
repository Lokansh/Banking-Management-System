package com.bankingmanagement.bankingmanagement.chequebook.model;

public class ChequeRequest {

    private String customerId;;
    private String requestStatus;
    private String requestType;

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String cardNumber) {
        this.customerId = customerId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType;
    }
}
