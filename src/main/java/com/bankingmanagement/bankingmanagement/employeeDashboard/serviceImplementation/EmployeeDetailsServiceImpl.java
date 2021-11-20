package com.bankingmanagement.bankingmanagement.employeeDashboard.serviceImplementation;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.beans.factory.annotation.Autowired;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.database.GetEmployeeDetailsDao;
import com.bankingmanagement.bankingmanagement.employeeDashboard.database.GetEmployeeDetailsDaoImpl;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.EmployeeDetailsService;

public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private DatabaseConnectionDao databaseConnectionDAO;

	@Autowired
	private GetEmployeeDetailsDao getEmployeeDetailsDao;

	@Override
	public String getEmployeeDetails(String id) throws EmployeeDetailsException {
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet empResultSet = statement.executeQuery(getEmployeeDetailsDao.getEmployeeDetailsData(id))) {

			if (empResultSet == null) {
                throw new EmployeeDetailsException("Invalid request");
            }
            if (empResultSet.next()) {
                                return "";
            }
            else {
                throw new EmployeeDetailsException("Invalid email and/or password");
            }
			
		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new EmployeeDetailsException("Internal Error while fetching employee data");
		}

	}
}
