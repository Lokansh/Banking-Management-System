package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import org.springframework.stereotype.Component;

@Component
public class GetCustomerDaoImpl implements GetCustomedDao {

	@Override
	public String getCustomerData(String id){
		return "SELECT * FROM Customer LEFT JOIN `Customer-Account` on Customer.CustomerID = `Customer-Account`.CustomerID where Customer.CustomerID='"+id+"';";
	}
}
