package com.bankingmanagement.bankingmanagement.fundManipulation.model;

public class Statement {
	private String customerId;
	private String timeStamp;
	private String amount;
	private String type;
	private String fromToAccount;
	private String mode;
	private int id;
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(String time_Stamp) {
		this.timeStamp = time_Stamp;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getFromToAccount() {
		return fromToAccount;
	}
	public void setFromToAccount(String fromToAccount) {
		this.fromToAccount = fromToAccount;
	}
	public String getMode() {
		return mode;
	}
	public void setMode(String mode) {
		this.mode = mode;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
}
