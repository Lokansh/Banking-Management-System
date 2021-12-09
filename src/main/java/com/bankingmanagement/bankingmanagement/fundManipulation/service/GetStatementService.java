package com.bankingmanagement.bankingmanagement.fundManipulation.service;

import java.util.List;

import com.bankingmanagement.bankingmanagement.fundManipulation.exception.StatementException;
import com.bankingmanagement.bankingmanagement.fundManipulation.model.Statement;

public interface GetStatementService {
	List<Statement> getStatement(String id) throws StatementException;
}
