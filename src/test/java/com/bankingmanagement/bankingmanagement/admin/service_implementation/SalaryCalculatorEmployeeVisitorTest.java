package com.bankingmanagement.bankingmanagement.admin.service_implementation;

import com.bankingmanagement.bankingmanagement.admin.model.Employee;
import com.bankingmanagement.bankingmanagement.admin.model.Manager;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SalaryCalculatorEmployeeVisitorTest {

	@Test
	void visitEmployee() {

		int expectedSalary = 1600;
		Employee employee = new Employee("employee",20,1000);
		SalaryCalculatorEmployeeVisitor salaryCalculatorEmployeeVisitor = new SalaryCalculatorEmployeeVisitor();

		int actualSalary = salaryCalculatorEmployeeVisitor.visitEmployee(employee);
		assertEquals(expectedSalary,actualSalary);

	}

	@Test
	void visitManager() {
		int expectedSalary = 1900;
		Manager manager = new Manager("manager",20,1000);
		SalaryCalculatorEmployeeVisitor salaryCalculatorEmployeeVisitor = new SalaryCalculatorEmployeeVisitor();

		int actualSalary = salaryCalculatorEmployeeVisitor.visitManager(manager);
		assertEquals(expectedSalary,actualSalary);

	}
}