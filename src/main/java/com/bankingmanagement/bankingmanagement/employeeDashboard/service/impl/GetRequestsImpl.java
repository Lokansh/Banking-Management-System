package com.bankingmanagement.bankingmanagement.employeeDashboard.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.database.RequestDao;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.CustomerDataException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.RequestException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Customer;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Request;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.GetRequests;

@Service
public class GetRequestsImpl implements GetRequests {
	@Autowired
	private DatabaseConnectionDao databaseConnectionDAO;

	@Autowired
	private RequestDao requestDao;
	List<Request> requests = new ArrayList<Request>();

	@Override
	public List<Request> getRequest() throws RequestException {
		System.out.println("1111");
		try (final Connection connection = databaseConnectionDAO.getConnection();
				
				final Statement statement = connection.createStatement();
				final ResultSet requestResultSet = statement.executeQuery(requestDao.getRequests())) {
			System.out.println("2222");
			if (requestResultSet == null) {
				System.out.println("3333");
				throw new RequestException("Invalid request");
			}
//			List<String> nameList = new ArrayList<String>();

			if (requestResultSet.first()) {
				System.out.println("4444");
				while (requestResultSet.next()) {
					Request req = new Request();
					req.setCustomerId(requestResultSet.getInt("CustomerId"));
					req.setRequestData(requestResultSet.getNString("Request"));
					req.setStatus(requestResultSet.getNString("Status"));
					req.setRequestId(requestResultSet.getInt("RequestId"));
					requests.add(req);
				}

			} else {
				throw new RequestException("Internal Server Error");
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new RequestException("Internal Error while fetching customer data");
		}

		return requests;
	}
}
