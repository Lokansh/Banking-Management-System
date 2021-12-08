package com.bankingmanagement.bankingmanagement.ccservice.service;


import com.bankingmanagement.bankingmanagement.ccservice.exception.CreditCardException;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditCardInfo;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditScoreInfo;

import java.util.List;

public interface CreditCardService {


    List<CreditCardInfo> getCCList(String userId) throws CreditCardException;

    CreditScoreInfo getCreditScore(String sin) throws CreditCardException;

    String getCreditCardLimit(String userId) throws CreditCardException;

    String getSalary(String userId) throws CreditCardException;

    boolean submitRequest(String userId,String salary) throws CreditCardException;

    boolean checkCustCC(String userId) throws CreditCardException;
}
