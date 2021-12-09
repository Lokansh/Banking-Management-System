package com.bankingmanagement.bankingmanagement.employeeDashboard.database;

import static com.bankingmanagement.bankingmanagement.employeeDashboard.database.EmployeeDashboardConstants.*;

import org.springframework.stereotype.Component;

@Component
public class GetEmployeeDetailsDaoImpl implements GetEmployeeDetailsDao{

	@Override
    public String getEmployeeDetailsData(String id) {
        return "SELECT " +
                EMP_FNAME + ", " +
                EMP_LNAME + ", " +
                EMP_MANAGER + ", " +
                EMP_SALARY +
                " FROM " +
                EMPLOYEE_TABLE +
                " WHERE " +
                EMP_ID + "=\"" + id + "\";";
    }
	
}
