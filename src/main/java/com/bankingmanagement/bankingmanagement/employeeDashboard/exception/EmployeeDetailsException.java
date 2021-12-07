package com.bankingmanagement.bankingmanagement.employeeDashboard.exception;

public class EmployeeDetailsException extends Exception{
	
    private final String errorMessage;

    public EmployeeDetailsException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    @Override
    public String toString() {
        return "employeeDetailsException{" +
                "errorMessage='" + errorMessage + '\'' +
                '}';
    }

}
