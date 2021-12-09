package com.bankingmanagement.bankingmanagement.admin.exception;

public class EmployeeNotFoundException extends Exception{
	private String errorMessage;

	public EmployeeNotFoundException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return "EmployeeNotFoundException{" +
					   "errorMessage='" + errorMessage + '\'' +
					   '}';
	}
}
