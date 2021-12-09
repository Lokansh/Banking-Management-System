package com.bankingmanagement.bankingmanagement.fundManipulation.database;

import org.springframework.stereotype.Component;

@Component
public class GetDetailsDaoImpl implements GetDetailsDao {

	@Override
	public String getCustomerData(String id){
		return "SELECT * FROM Customer INNER JOIN `Customer_Account` on Customer.CustomerID = `Customer_Account`.CustomerID where Customer.CustomerID='"+id+"';";
	}
	
	@Override
	public String getCustomerBalance(String id){
		return "SELECT * FROM `Customer_Account` where CustomerID='"+id+"';";
	}
}
