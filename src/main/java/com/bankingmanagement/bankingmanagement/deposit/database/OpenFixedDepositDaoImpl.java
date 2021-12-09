package com.bankingmanagement.bankingmanagement.deposit.database;

import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;
import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.deposit.database.DepositConstants.*;

@Component
public class OpenFixedDepositDaoImpl implements OpenFixedDepositDao{

    @Override
    public String getCustomerDetails(String customerId){
        return "SELECT * FROM " +
                CUSTOMER_ACCOUNT_TABLE +
                " WHERE " +
                CUSTOMER_ID + "=\"" + customerId +
                "\"" + "LIMIT 1" +";";
    }

    @Override
    public String openFixedDepositQuery(Deposit deposit) {
        return "INSERT INTO " + DEPOSIT_TABLE + "(" +
                CUSTOMER_ID + ", " +
                AMOUNT + ", " +
                DEPOSIT_TYPE + ", " +
                TENURE + ", " +
                INTEREST + ", " +
                OPEN_DATE + ", " +
                MATURITY_DATE +
                ") " +
                "VALUES (" +
                "\"" + deposit.getCustomerId() + "\", " +
                "\"" + deposit.getAmount()  + "\", " +
                "\"" + deposit.getDepositType()  + "\", " +
                "\"" + deposit.getTenure()  + "\", " +
                "\"" + deposit.getInterest()  + "\", " +
                "\"" + deposit.getOpenDate()  + "\", " +
                "\"" + deposit.getMaturityDate()  + "\"" +
                ");";
    }

    @Override
    public String deductBalanceFromCustomerAccount(Deposit deposit, CustomerAccount customerAccount) throws DepositException {
        Float oldBalanceFloat = Float.parseFloat(customerAccount.getBalance());
        Integer oldBalance = Math.round(oldBalanceFloat);
        Integer fdAmount = Integer.parseInt(deposit.getAmount());
        int deductedAmount = oldBalance.intValue() - fdAmount.intValue();

        if(deductedAmount < 0) {
            throw new DepositException("You don't have sufficient balance in account to open fixed deposit");
        }
        String deductedAmountStr = String.valueOf(deductedAmount);
        if(customerAccount.getCustomerId() == null || deductedAmountStr == null){
            throw new DepositException("Account not present or amount not present");
        }
        return "UPDATE " + CUSTOMER_ACCOUNT_TABLE +
                " SET " + BALANCE + " = " + deductedAmountStr + " WHERE " +
                CA_CUSTOMER_ID + "=\"" + customerAccount.getCustomerId() + "\";";
    }
}