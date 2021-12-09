package com.bankingmanagement.bankingmanagement.fundManipulation.database;

public interface FundManipulationDao {

	String updateBalance(String id,float balance);
	String getBalance(String id);
	
}
