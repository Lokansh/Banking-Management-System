package com.bankingmanagement.bankingmanagement.ccservice.service;


import com.bankingmanagement.bankingmanagement.ccservice.exception.CreditCardException;
import com.bankingmanagement.bankingmanagement.ccservice.model.CreditCardInfo;

import java.util.List;

public interface CreditCardService {


    List<CreditCardInfo> getCCList(String userId) throws CreditCardException;
}
