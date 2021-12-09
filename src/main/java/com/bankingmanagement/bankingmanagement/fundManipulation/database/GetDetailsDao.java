package com.bankingmanagement.bankingmanagement.fundManipulation.database;

public interface GetDetailsDao {

	String  getCustomerData(String id);
	String getCustomerBalance(String id);
}
