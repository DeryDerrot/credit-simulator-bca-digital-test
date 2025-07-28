package com.creditsimulator.service;

import com.creditsimulator.model.LoanRequest;
import com.creditsimulator.model.LoanResult;

public interface CreditService {

    LoanResult calculateCredit(LoanRequest request);

}