package com.bankingmanagement.bankingmanagement.fundManipulation.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.fundManipulation.database.GetStatementDao;
import com.bankingmanagement.bankingmanagement.fundManipulation.exception.StatementException;
import com.bankingmanagement.bankingmanagement.fundManipulation.model.Statement;
import com.bankingmanagement.bankingmanagement.fundManipulation.service.GetStatementService;
@Service
public class GetStatementServiceImpl implements GetStatementService {
	
	@Autowired
	private DatabaseConnectionDao databaseConnectionDAO;

	@Autowired
	private GetStatementDao getStatementDao;
	
	@Override
	public List<Statement> getStatement(String id) throws StatementException{
		List<Statement> statements = new ArrayList<Statement>();
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final java.sql.Statement statement = connection.createStatement();
				final ResultSet requestResultSet = statement.executeQuery(getStatementDao.getStatement(id))) {
//			requestResult
			if (requestResultSet == null) {
				throw new StatementException("Invalid request");
			} else {
				while (requestResultSet.next()) {
					Statement req = new Statement();
					req.setId(requestResultSet.getInt("ID"));
					req.setAmount(requestResultSet.getNString("Amount"));
					req.setFromToAccount(requestResultSet.getNString("From_To_Account"));
					req.setMode(requestResultSet.getNString("Mode"));
					req.setType(requestResultSet.getNString("Type"));
					req.setTimeStamp(requestResultSet.getDate("Time_Stamp").toString());
					statements.add(req);
				}
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new StatementException("Internal Error while fetching customer data");
		}
		return statements;
		
	}
}
