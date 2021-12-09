package com.bankingmanagement.bankingmanagement.deposit.database;

import com.bankingmanagement.bankingmanagement.deposit.exception.DepositException;
import com.bankingmanagement.bankingmanagement.deposit.model.CustomerAccount;
import com.bankingmanagement.bankingmanagement.deposit.model.Deposit;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.ui.ModelMap;

import javax.servlet.http.HttpSession;

import static org.junit.jupiter.api.Assertions.*;

class CloseFixedDepositDaoImplTest {

    @Test
    void getAllDepositDetailsQuery() {
        String expectedQuery = "SELECT * FROM Deposit WHERE CustomerId=\"user\";";
        CloseFixedDepositDaoImpl closeFixedDepositDaoImpl = new CloseFixedDepositDaoImpl();
        String username = "user";

        String actualQuery = closeFixedDepositDaoImpl.getAllDepositDetailsQuery(username);
        assertEquals(expectedQuery,actualQuery);
    }

    @Test
    void closeDeposit() {
        String expectedQuery = "DELETE FROM Deposit WHERE DepositID=\"user\";";
        CloseFixedDepositDaoImpl closeFixedDepositDaoImpl = new CloseFixedDepositDaoImpl();
        String username = "user";

        String actualQuery = closeFixedDepositDaoImpl.closeDeposit(username);
        assertEquals(expectedQuery,actualQuery);
    }

    /*
    @Test
    void addBalanceToAccount() throws DepositException {
        String expectedQuery;
        CloseFixedDepositDaoImpl closeFixedDepositDaoImpl = new CloseFixedDepositDaoImpl();

        Deposit deposit = new Deposit("2","sdf","sdfsdf","sdfsdfsd","dsfgdsfdsf","sdfdsfsdf","sfsdfs");
        CustomerAccount customerAccount =  new CustomerAccount("sdfsdfsd","sfsdfs","sfsd");

        String actualQuery = closeFixedDepositDaoImpl.addBalanceToAccount(deposit,customerAccount);
        System.out.println(actualQuery);
        //assertEquals(expectedQuery,actualQuery);
    }
     */
}