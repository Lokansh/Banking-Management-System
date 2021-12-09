package com.bankingmanagement.bankingmanagement.deposit.database;


import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;

public interface CloseFixedDepositDao {
    String getAllDepositDetailsQuery (String customerId);
    String closeDeposit (String requestId);
    String addBalanceToAccount (Deposit deposit, CustomerAccount customerAccount) throws DepositException;
}
