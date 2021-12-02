package com.bankingmanagement.bankingmanagement.loan.service;

import com.bankingmanagement.bankingmanagement.loan.exception.LoanException;
import com.bankingmanagement.bankingmanagement.loan.model.EligibilityInfo;
import com.bankingmanagement.bankingmanagement.loan.model.Loan;
import com.bankingmanagement.bankingmanagement.loan.model.LoanInfo;

import java.util.List;

public interface LoanService {


     String applyLoan(Loan loan,String userId) throws LoanException;

    List<LoanInfo> getAppliedLoans(String userId) throws LoanException;
    boolean deleteLoanRequest(int loanId) throws LoanException;

    boolean checkLoanEligibility(EligibilityInfo info, String userId) throws LoanException;
}
