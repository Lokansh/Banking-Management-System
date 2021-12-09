package com.bankingmanagement.bankingmanagement.deposit.database;

import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;
import org.springframework.stereotype.Component;

import static com.bankingmanagement.bankingmanagement.deposit.database.DepositConstants.*;

@Component
public class CloseFixedDepositDaoImpl implements CloseFixedDepositDao{
    @Override
    public String getAllDepositDetailsQuery(String customerId) {
        return "SELECT * FROM " +
                DEPOSIT_TABLE +
                " WHERE " +
                CUSTOMER_ID + "=\"" + customerId +
                "\"" + ";";
    }

    @Override
    public String closeDeposit(String depositId){
        return "DELETE FROM " +
                DEPOSIT_TABLE +
                " WHERE " +
                DEPOSIT_ID + "=\"" + depositId +
                "\"" + ";";
    }

    @Override
    public String addBalanceToAccount (Deposit deposit, CustomerAccount customerAccount) throws DepositException {
        Float oldBalanceFloat = Float.parseFloat(customerAccount.getBalance());
        Integer oldBalance = Math.round(oldBalanceFloat);
        Integer fdAmount = Integer.parseInt(deposit.getAmount());
        int addedAmountInt = oldBalance.intValue() + fdAmount.intValue();

        String addingAmountStr = String.valueOf(addedAmountInt);
        if(customerAccount.getCustomerId() == null || addingAmountStr == null){
            throw new DepositException("Account not present or amount not present");
        }

        return "UPDATE " + CUSTOMER_ACCOUNT_TABLE +
                " SET " + BALANCE + " = " + addingAmountStr + " WHERE " +
                CA_CUSTOMER_ID + "=\"" + customerAccount.getCustomerId() + "\";";
    }

}
