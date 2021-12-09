package com.bankingmanagement.bankingmanagement.employeeDashboard.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.database.GetEmployeeDetailsDao;
import com.bankingmanagement.bankingmanagement.employeeDashboard.exception.EmployeeDetailsException;
import com.bankingmanagement.bankingmanagement.employeeDashboard.model.Employee;
import com.bankingmanagement.bankingmanagement.employeeDashboard.service.EmployeeDetailsService;
import static com.bankingmanagement.bankingmanagement.employeeDashboard.database.EmployeeDashboardConstants.*;
@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {

	@Autowired
	private DatabaseConnectionDao databaseConnectionDAO;

	@Autowired
	private GetEmployeeDetailsDao getEmployeeDetailsDao;

	@Override
	public Employee getEmployeeDetails(String id) throws EmployeeDetailsException {
		try (final Connection connection = databaseConnectionDAO.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet empResultSet = statement
						.executeQuery(getEmployeeDetailsDao.getEmployeeDetailsData(id))) {

			if (empResultSet == null) {
				
				throw new EmployeeDetailsException("Invalid request");
			}
//			List<String> nameList = new ArrayList<String>();
			Employee emp=new Employee();
			if (empResultSet.next()) {
				emp.setEmployeeFirstName(empResultSet.getNString(EMP_FNAME));
				emp.setEmployeeLastName(empResultSet.getNString(EMP_LNAME));
				emp.setEmployeeSalary(empResultSet.getDouble(EMP_SALARY));
				emp.setEmployeeManager(empResultSet.getNString(EMP_MANAGER));		
				return emp;
			} else {
				throw new EmployeeDetailsException("Internal Server Error");
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new EmployeeDetailsException("Internal Error while fetching employee data");
		}

	}
}
