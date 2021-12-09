package com.bankingmanagement.bankingmanagement.admin.database;

import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.admin.database.SalaryConstant.*;

@Component
public class EmployeeDaoImpl implements EmployeeDao {
	@Override
	public String getEmployeeQuery(String employeeName) {
		return "SELECT " +
					   EMPLOYEE_USERNAME + ", " +
					   EMPLOYEE_WORKING_HOURS + ", " +
					   EMPLOYEE_BONUS_PAY + ", " +
					   EMPLOYEE_IS_MANAGER +
					   " FROM " +
					   EMPLOYEE_TABLE +
					   " WHERE " +
					   EMPLOYEE_USERNAME + "=\"" + employeeName + "\";";
	}
}
