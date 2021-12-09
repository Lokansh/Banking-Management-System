package com.bankingmanagement.bankingmanagement.fundManipulation.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.fundManipulation.database.FundManipulationDao;
import com.bankingmanagement.bankingmanagement.fundManipulation.exception.FundTransferException;
import com.bankingmanagement.bankingmanagement.fundManipulation.service.FundTransferService;

@Service
public class FundTransferServiceImpl implements FundTransferService {
	@Autowired
	private DatabaseConnectionDao databaseConnectionDAO;

	@Autowired
	private FundManipulationDao fundManipulationDao;

	@Override
	public boolean transferFund(String custId, String recieverId, int amount, String type)

			throws FundTransferException {
		
		float senderBalance = getBalance(custId);
		float recieverBalance = getBalance(recieverId);
		
		if (amount > senderBalance)
			throw new FundTransferException("Insufficient balance");
		if (type.equals("imps") && amount > 4000) {
			throw new FundTransferException("For IMPS amount must be less than 4000 CAD");
		} else if (type.equals("rtgs") && amount < 4000) {
			throw new FundTransferException("For RTGS amount must be greater than 4000 CAD");
		}

		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();

		) {
			int i = statement.executeUpdate(fundManipulationDao.updateBalance(custId, senderBalance - amount));

			int j = statement.executeUpdate(fundManipulationDao.updateBalance(recieverId, recieverBalance + amount));
			if (i == 0 || j == 0) {
				throw new FundTransferException("Internal Server Error");
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new FundTransferException("Internal Error while fetching customer data");
		}

		return true;
	}

	@Override
	public float getBalance(String CustId) throws FundTransferException {
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet custResultSet = statement.executeQuery(fundManipulationDao.getBalance(CustId))) {

			if (custResultSet == null) {

				throw new FundTransferException("Customer do not exist");
			}
//			List<String> nameList = new ArrayList<String>();
			if (custResultSet.next()) {
				float balance = custResultSet.getFloat("Balance");
				return balance;
			} else {
				throw new FundTransferException("Internal Server Error");
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new FundTransferException("Internal Error while fetching customer data");
		}

	}
}
