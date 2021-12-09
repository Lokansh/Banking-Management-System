package com.bankingmanagement.bankingmanagement.deposit.service;

import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;

public interface OpenFixedDepositService {
    CustomerAccount getAccount(String customerId) throws DepositException;
    boolean fdRequest(Deposit deposit, CustomerAccount customerAccount) throws DepositException;
}
