package com.bankingmanagement.bankingmanagement.employeeDashboard.model;

public class Employee {
	private int employeeID;
	private String employeeFirstName;
	private String employeeLastName; 
	private String employeeManager ;
	private double employeeSalary;
	public int getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(int employeeID) {
		this.employeeID = employeeID;
	}
	public String getEmployeeFirstName() {
		return employeeFirstName;
	}
	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}
	public String getEmployeeLastName() {
		return employeeLastName;
	}
	public void setEmployeeLastName(String employeeLastName) {
		this.employeeLastName = employeeLastName;
	}
	public String getEmployeeManager() {
		return employeeManager;
	}
	public void setEmployeeManager(String employeeManager) {
		this.employeeManager = employeeManager;
	}
	public double getEmployeeSalary() {
		return employeeSalary;
	}
	public void setEmployeeSalary(double employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	
}
