package com.bankingmanagement.bankingmanagement.deposit.service;

import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface CloseFixedDepositService {
    List<Deposit> getAllDeposit (String customerId) throws DepositException;
    List<Deposit> saveDataIntoDepositList(ResultSet requestResultSet) throws DepositException, SQLException;
    boolean liquidateDeposit(Deposit deposit, CustomerAccount customerAccount) throws DepositException;
}
