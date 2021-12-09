package com.bankingmanagement.bankingmanagement.fundManipulation.database;

import org.springframework.stereotype.Component;

@Component
public class FundManipulationDaoImpl implements FundManipulationDao {
	@Override
	public String updateBalance(String id,float balance) {
		return "UPDATE `CSCI5308_20_PRODUCTION`.`Customer_Account` SET `Balance` = "+balance+" WHERE `CustomerID` = '"+id+"';";
	}
	
	@Override
	public String getBalance(String id) {
		return "SELECT Balance FROM CSCI5308_20_PRODUCTION.Customer_Account where CustomerID='"+id+"';";
	}
	
}
