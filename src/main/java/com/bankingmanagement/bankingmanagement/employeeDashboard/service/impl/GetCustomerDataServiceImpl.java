package com.bankingmanagement.bankingmanagement.employeeDashboard.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.database.GetCustomedDao;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.CustomerDataException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Customer;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Employee;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.GetCustomerDataService;

@Service
public class GetCustomerDataServiceImpl implements GetCustomerDataService {
	
	@Autowired
	private DatabaseConnectionDao databaseConnectionDAO;
	
	@Autowired
	private GetCustomedDao getCustomerDao;
	
	@Override
	public Customer getCustomerDetails(String id) throws CustomerDataException{
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet custResultSet = statement
						.executeQuery(getCustomerDao.getCustomerData(id))) {

			if (custResultSet == null) {
				
				throw new CustomerDataException("Invalid request");
			}
//			List<String> nameList = new ArrayList<String>();
			Customer cust=new Customer();
			if (custResultSet.next()) {
				cust.setId(id);
				cust.setFirstName(custResultSet.getNString("CustomerFirstName"));
				cust.setLastName(custResultSet.getNString("CustomerLastName"));
				cust.setAddress1(custResultSet.getNString("CustomerAddress1"));
				cust.setAddress2(custResultSet.getNString("CustomerAddress1"));
				cust.setCity(custResultSet.getNString("City"));
				cust.setZipCode(custResultSet.getNString("ZipCode"));
				cust.setEmail(custResultSet.getNString("CustomerEmail"));
				cust.setPhone(custResultSet.getNString("PhoneNumber"));
				cust.setSin(custResultSet.getNString("SIN"));
				cust.setBalance(custResultSet.getDouble("Balance"));
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
