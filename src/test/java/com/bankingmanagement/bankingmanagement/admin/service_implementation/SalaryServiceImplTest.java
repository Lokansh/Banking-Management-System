package com.bankingmanagement.bankingmanagement.admin.service_implementation;

import com.bankingmanagement.bankingmanagement.admin.exception.EmployeeNotFoundException;
import com.bankingmanagement.bankingmanagement.admin.service.SalaryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SalaryServiceImplTest {

	@Autowired
	SalaryService salaryService;

	@Test
	void calculateSalaryError() throws EmployeeNotFoundException {

		String expected = "Invalid Employee/Manager Id";

		EmployeeNotFoundException actualException = assertThrows(EmployeeNotFoundException.class,() -> salaryService.calculateSalary("dummyEmployee"),"Expected to throw invalid user error");

		assertEquals(expected,actualException.getErrorMessage().trim());
	}
}