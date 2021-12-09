package com.bankingmanagement.bankingmanagement.fundManipulation.service;

import com.bankingmanagement.bankingmanagement.fundManipulation.exception.FundTransferException;

public interface FundTransferService {

	boolean transferFund(String CustId, String RecieverId, int amount, String type) throws FundTransferException;

	float getBalance(String CustId) throws FundTransferException;
}
