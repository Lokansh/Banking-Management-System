package com.bankingmanagement.bankingmanagement.deposit.database;

import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;

public interface OpenFixedDepositDao {
    String getCustomerDetails(String customerId);
    String openFixedDepositQuery(Deposit deposit);
    String deductBalanceFromCustomerAccount(Deposit deposit, CustomerAccount customerAccount) throws DepositException;
}
