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

			System.out.println("===================================================444444");
			if (empResultSet == null) {
				System.out.println("===================================================6666666");
				
				throw new EmployeeDetailsException("Invalid request");
			}
//			List<String> nameList = new ArrayList<String>();
			Employee emp=new Employee();
			if (empResultSet.next()) {
				System.out.println("===================================================77777");
				emp.setEmployeeFirstName(empResultSet.getNString("EmployeeFirstName"));
				emp.setEmployeeLastName(empResultSet.getNString("EmployeeLastName"));
				emp.setEmployeeSalary(empResultSet.getDouble("EmployeeSalary"));
				emp.setEmployeeManager(empResultSet.getNString("EmployeeManager"));
				
				System.out.println(empResultSet.getNString("EmployeeFirstName"));
				return emp;
			} else {
				System.out.println("===================================================88888");
				throw new EmployeeDetailsException("Internal Server Error");
			}

		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new EmployeeDetailsException("Internal Error while fetching employee data");
		}

	}
}
