package com.bankingmanagement.bankingmanagement.deposit.model;

public class Deposit {

    private String depositId;
    private String customerId;
    private String amount;
    private String depositType;
    private String tenure;
    private String interest;
    private String openDate;
    private String maturityDate;

    public Deposit() {
    }

    public Deposit(String depositId, String customerId, String amount,
                   String depositType, String tenure, String interest,
                   String openDate, String maturityDate) {
        this.depositId = depositId;
        this.customerId = customerId;
        this.amount = amount;
        this.depositType = depositType;
        this.tenure = tenure;
        this.interest = interest;
        this.openDate = openDate;
        this.maturityDate = maturityDate;
    }

    public Deposit( String customerId, String amount, String depositType,
                    String tenure, String interest, String openDate,
                    String maturityDate) {
        this.customerId = customerId;
        this.amount = amount;
        this.depositType = depositType;
        this.tenure = tenure;
        this.interest = interest;
        this.openDate = openDate;
        this.maturityDate = maturityDate;
    }

    public String getDepositId() {
        return depositId;
    }
    public void setDepositId(String depositId) {
        this.depositId = depositId;
    }

    public String getCustomerId() {
        return customerId;
    }
    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getAmount() {
        return amount;
    }
    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getDepositType() {
        return depositType;
    }
    public void setDepositType(String depositType) {
        this.depositType = depositType;
    }

    public String getTenure() {
        return tenure;
    }
    public void setTenure(String tenure) {
        this.tenure = tenure;
    }

    public String getInterest() {
        return interest;
    }
    public void setInterest(String interest) {
        this.interest = interest;
    }

    public String getOpenDate() {
        return openDate;
    }
    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getMaturityDate() {
        return maturityDate;
    }
    public void setMaturityDate(String maturityDate) {
        this.maturityDate = maturityDate;
    }

}
