package com.bankingmanagement.bankingmanagement.loan.model;

public class EligibilityInfo {
    private String sin;
    private String salary;
    private String age;
    private String loanAmount;
    private String loanType;

    public EligibilityInfo(String sin, String salary, String age, String loanAmount, String loanType) {
        this.sin = sin;
        this.salary = salary;
        this.age = age;
        this.loanAmount = loanAmount;
        this.loanType = loanType;
    }

    public String getSin() {
        return sin;
    }

    public void setSin(String sin) {
        this.sin = sin;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getLoanType() {
        return loanType;
    }

    public void setLoanType(String loanType) {
        this.loanType = loanType;
    }

    public String getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }
}
