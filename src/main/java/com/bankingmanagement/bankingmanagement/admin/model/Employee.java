package com.bankingmanagement.bankingmanagement.admin.model;

import com.bankingmanagement.bankingmanagement.admin.service.EmployeeVisitor;

public class Employee implements EmployeeElement{
	private String employeeId;
	private int workingHours;
	private int bonusPay;

	public Employee(String employeeId, int workingHours, int bonusPay) {
		this.employeeId = employeeId;
		this.workingHours = workingHours;
		this.bonusPay = bonusPay;
	}

	public String getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}

	public int getWorkingHours() {
		return workingHours;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}
	public int getBonusPay() {
		return bonusPay;
	}

	public void setBonusPay(int bonusPay) {
		this.bonusPay = bonusPay;
	}
	@Override
	public int accept(EmployeeVisitor visitor) {
		return visitor.visitEmployee(this);
	}
}
