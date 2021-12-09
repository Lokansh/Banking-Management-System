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
     double checkEligibilityAndInterest(EligibilityInfo info, String userId) throws LoanException;
     double calculateInterestRates(EligibilityInfo info);
     double getLoanInterestByType(String loanType);
 boolean approveLoan(int id) throws LoanException;
 boolean rejectLoan(int id) throws LoanException;
 List<LoanInfo>  getAllPendingLoans() throws LoanException;
 List<LoanInfo> getAllApprovedLoans()throws LoanException;
 List<LoanInfo> getAllRejectedLoans()throws LoanException;
}
