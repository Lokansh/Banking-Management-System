package com.bankingmanagement.bankingmanagement.admin.service_implementation;

import com.bankingmanagement.bankingmanagement.admin.model.Employee;
import com.bankingmanagement.bankingmanagement.admin.model.Manager;
import com.bankingmanagement.bankingmanagement.admin.service.EmployeeVisitor;
import org.springframework.stereotype.Service;

import static com.bankingmanagement.bankingmanagement.admin.database.SalaryConstant.EMPLOYEE_HOURLY_RATE;
import static com.bankingmanagement.bankingmanagement.admin.database.SalaryConstant.MANAGER_HOURLY_RATE;

@Service
public class SalaryCalculatorEmployeeVisitor implements EmployeeVisitor {

	@Override
	public int visitEmployee(Employee employee) {
		int workingHours = employee.getWorkingHours();

		return EMPLOYEE_HOURLY_RATE*workingHours + employee.getBonusPay();
	}

	@Override
	public int visitManager(Manager manager) {
		int workingHours = manager.getWorkingHours();

		return MANAGER_HOURLY_RATE*workingHours + manager.getBonusPay();
	}
}
