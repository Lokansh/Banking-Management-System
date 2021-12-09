package com.bankingmanagement.bankingmanagement.fundManipulation.service.impl;

import static com.bankingmanagement.bankingmanagement.fundManipulation.database.CustomerDashboardConstants.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.fundManipulation.exception.CustomerDataException;
import com.bankingmanagement.bankingmanagement.fundManipulation.model.Customer;
import com.bankingmanagement.bankingmanagement.fundManipulation.service.CustomerDetailsService;
import com.bankingmanagement.bankingmanagement.fundManipulation.database.GetDetailsDao;

@Service
public class CustomerDetailsServiceImpl implements CustomerDetailsService {
	@Autowired
	private DatabaseConnectionDao databaseConnectionDAO;

	@Autowired
	private GetDetailsDao getDetailsDao;
	
	@Override
	public Customer getDetails(String id) throws CustomerDataException{
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet custResultSet = statement
						.executeQuery(getDetailsDao.getCustomerData(id))) {

			if (custResultSet == null) {
				
				throw new CustomerDataException("Invalid request");
			}
//			List<String> nameList = new ArrayList<String>();
			Customer cust=new Customer();
			if (custResultSet.next()) {
				cust.setId(id);
				cust.setFirstName(custResultSet.getNString(CUST_FNAME));
				cust.setLastName(custResultSet.getNString(CUST_LNAME));
				cust.setAddress1(custResultSet.getNString(CUST_ADD1));
				cust.setAddress2(custResultSet.getNString(CUST_ADD2));
				cust.setCity(custResultSet.getNString(CUST_CITY));
				cust.setZipCode(custResultSet.getNString(CUST_ZIP));
				cust.setEmail(custResultSet.getNString(CUST_EMAIL));
				cust.setPhone(custResultSet.getNString(CUST_PHONE));
				cust.setSin(custResultSet.getNString(CUST_SIN));
				cust.setBalance(custResultSet.getDouble(CUST_BAL));
				cust.setAccount(custResultSet.getInt(CUST_ACCOUNT));
				return cust;
			} else {
				throw new CustomerDataException("Internal Server Error");
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new CustomerDataException("Internal Error while fetching customer data");
		}

	}
}
