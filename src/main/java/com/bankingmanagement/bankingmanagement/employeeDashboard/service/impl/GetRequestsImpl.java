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
import com.bankingmanagement.bankingmanagement.employeeDashboard.database.ManageRequestsDao;
import com.bankingmanagement.bankingmanagement.employeeDashboard.database.RequestDao;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.RequestException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Request;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.GetRequests;

@Service
public class GetRequestsImpl implements GetRequests {
	@Autowired
	private DatabaseConnectionDao databaseConnectionDAO;

	@Autowired
	private RequestDao requestDao;
	List<Request> requests = new ArrayList<Request>();

	@Autowired
	private ManageRequestsDao manageRequestsDao;

	@Override
	public List<Request> getRequest() throws RequestException {

		List<Request> requests = new ArrayList<Request>();
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet requestResultSet = statement.executeQuery(requestDao.getRequests())) {
//			requestResult
			if (requestResultSet == null) {
				throw new RequestException("Invalid request");
			} else {
				requests = getRequestsStatus(requestResultSet);
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new RequestException("Internal Error while fetching customer data");
		}
		return requests;
	}

	@Override
	public List<Request> approvedHistory() throws RequestException {

		List<Request> requests = new ArrayList<Request>();
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet requestResultSet = statement.executeQuery(requestDao.approvedRequestHistory())) {
//			requestResult
			if (requestResultSet == null) {
				throw new RequestException("Invalid request");
			} else {
				requests = getRequestsStatus(requestResultSet);
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new RequestException("Internal Error while fetching customer data");
		}
		return requests;
	}

	@Override
	public List<Request> deniedHistory() throws RequestException {

		List<Request> requests = new ArrayList<Request>();
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet requestResultSet = statement.executeQuery(requestDao.deniedRequestHistory())) {
//			requestResult
			if (requestResultSet == null) {
				throw new RequestException("Invalid request");
			} else {
				requests = getRequestsStatus(requestResultSet);
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new RequestException("Internal Error while fetching customer data");
		}
		return requests;
	}

	@Override
	public List<Request> autoApprovedHistory() throws RequestException {

		List<Request> requests = new ArrayList<Request>();
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet requestResultSet = statement.executeQuery(requestDao.autoApprovedRequestHistory())) {
//			requestResult
			if (requestResultSet == null) {
				throw new RequestException("Invalid request");
			} else {
				requests = getRequestsStatus(requestResultSet);
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new RequestException("Internal Error while fetching customer data");
		}
		return requests;
	}

	@Override
	public void approveRequest(int requestId) throws RequestException {
		try (final Connection connection = databaseConnectionDAO.getConnection();

				final Statement statement = connection.createStatement();) {
			final int requestResultSet = statement.executeUpdate(manageRequestsDao.approveRequest(requestId));
			if (requestResultSet == 0) {
				throw new RequestException("Internal Server Error");
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new RequestException("Internal Error while fetching customer data");
		}

	}

	@Override
	public void denyRequest(int requestId) throws RequestException {
		try (final Connection connection = databaseConnectionDAO.getConnection();

				final Statement statement = connection.createStatement();) {
			final int requestResultSet = statement.executeUpdate(manageRequestsDao.denyRequest(requestId));
			if (requestResultSet == 0) {
				throw new RequestException("Internal Server Error");
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new RequestException("Internal Error while fetching customer data");
		}

	}

	List<Request> getRequestsStatus(ResultSet requestResultSet) throws SQLException {
		List<Request> requests = new ArrayList<Request>();
		while (requestResultSet.next()) {
			Request req = new Request();
			req.setCustomerId(requestResultSet.getNString("CustomerId"));
			req.setRequestData(requestResultSet.getNString("Request"));
			req.setStatus(requestResultSet.getNString("Status"));
			req.setRequestId(requestResultSet.getInt("RequestId"));
			requests.add(req);
		}
		return requests;
	}

}
