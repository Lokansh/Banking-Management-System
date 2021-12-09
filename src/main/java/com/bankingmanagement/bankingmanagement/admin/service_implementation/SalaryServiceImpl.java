package com.bankingmanagement.bankingmanagement.admin.service_implementation;

import com.bankingmanagement.bankingmanagement.admin.database.EmployeeDao;
import com.bankingmanagement.bankingmanagement.admin.exception.EmployeeNotFoundException;
import com.bankingmanagement.bankingmanagement.admin.model.Employee;
import com.bankingmanagement.bankingmanagement.admin.model.EmployeeElement;
import com.bankingmanagement.bankingmanagement.admin.model.Manager;
import com.bankingmanagement.bankingmanagement.admin.service.EmployeeVisitor;
import com.bankingmanagement.bankingmanagement.admin.service.SalaryService;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionDao;
import com.bankingmanagement.bankingmanagement.database.DatabaseConnectionException;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static com.bankingmanagement.bankingmanagement.admin.database.SalaryConstant.*;

@Service
public class SalaryServiceImpl implements SalaryService {
	private final EmployeeVisitor employeeVisitor;

	private final DatabaseConnectionDao databaseConnection;

	private final EmployeeDao employeeDao;

	public SalaryServiceImpl(EmployeeVisitor employeeVisitor, DatabaseConnectionDao databaseConnection, EmployeeDao employeeDao) {
		this.employeeVisitor = employeeVisitor;
		this.databaseConnection = databaseConnection;
		this.employeeDao = employeeDao;
	}

	@Override
	public int calculateSalary( String employeeName) throws EmployeeNotFoundException {

		EmployeeElement employeeElement = validateEmployee(employeeName);

		return employeeElement.accept(employeeVisitor);
	}

	private EmployeeElement validateEmployee(String employeeName) throws EmployeeNotFoundException {

		try (
				final Connection connection = databaseConnection.getConnection();
				final Statement statement = connection.createStatement();
				final ResultSet employeeResultSet = statement.executeQuery(employeeDao.getEmployeeQuery(employeeName))) {

			if (employeeResultSet.next()) {
				int workingHours = employeeResultSet.getInt(EMPLOYEE_WORKING_HOURS);
				int bonusPay = employeeResultSet.getInt(EMPLOYEE_BONUS_PAY);
				boolean isManager = employeeResultSet.getBoolean(EMPLOYEE_IS_MANAGER);
				if(isManager){
					return new Manager(employeeName,workingHours,bonusPay);
				}
				else {
					return new Employee(employeeName,workingHours,bonusPay);
				}
			}
			else {
				throw new EmployeeNotFoundException("Invalid Employee/Manager Id");
			}
		} catch (SQLException | DatabaseConnectionException sqlException) {
			sqlException.printStackTrace();
			throw new EmployeeNotFoundException("Invalid Employee/Internal Error while validating employee");
		}
	}

}
