package com.bankingmanagement.bankingmanagement.fundManipulation.database;

import org.springframework.stereotype.Component;

@Component
public class GetStatementDaoImpl implements GetStatementDao {
	@Override
	public String  getStatement(String id) {
		return "SELECT * FROM CSCI5308_20_PRODUCTION.Transactions where CustomerID='"+id+"';";
	};
}
