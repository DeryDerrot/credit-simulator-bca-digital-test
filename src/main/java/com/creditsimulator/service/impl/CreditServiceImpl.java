package com.creditsimulator.service.impl;

import com.creditsimulator.model.LoanRequest;
import com.creditsimulator.model.LoanResult;
import com.creditsimulator.model.LoanResultDetail;
import com.creditsimulator.service.CreditService;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class CreditServiceImpl implements CreditService {

    private double interestRate;

    public CreditServiceImpl(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public LoanResult calculateCredit(LoanRequest request) {
        LoanResult loanResult = new LoanResult();

        loanResult.setVehiclePrice(request.getTotalLoanAmount() + request.getDownPayment());
        loanResult.setTenor(request.getLoanTenure());
        loanResult.setDownPayment(request.getDownPayment());

        List<LoanResultDetail> details = new ArrayList<>();

        BigDecimal loanAmount = BigDecimal.ZERO;
        BigDecimal interest = new BigDecimal(Double.toString(interestRate));
        BigDecimal totalAmount = BigDecimal.ZERO;
        BigDecimal installmentMonthly = BigDecimal.ZERO;
        BigDecimal installmentYearly = BigDecimal.ZERO;
        BigDecimal avarageMonthly = BigDecimal.ZERO;

        for (int i = 0; i < request.getLoanTenure(); i++) {
            LoanResultDetail loanResultDetail = new LoanResultDetail();
            if (i == 0) {
                loanResultDetail.setRate(interest);
                loanResultDetail.setLoanAmount(BigDecimal.valueOf(request.getTotalLoanAmount()));
                loanAmount = BigDecimal.valueOf(request.getTotalLoanAmount());
                totalAmount = loanAmount.add(loanAmount.multiply(interest));
                installmentMonthly = totalAmount.divide(BigDecimal.valueOf(12).multiply(BigDecimal.valueOf(request.getLoanTenure())), 2, RoundingMode.HALF_UP);
            } else {
                if (i % 2 == 0) {
                    interest = interest.add(BigDecimal.valueOf(0.5)).setScale(2, RoundingMode.HALF_UP);
                } else {
                    interest = interest.add(BigDecimal.valueOf(0.1)).setScale(2, RoundingMode.HALF_UP);
                }

                loanAmount = totalAmount.subtract(installmentYearly);
                totalAmount = loanAmount.add(loanAmount.multiply(interest));
                installmentMonthly = totalAmount.divide(BigDecimal.valueOf(12).multiply(BigDecimal.valueOf(request.getLoanTenure())), 2, RoundingMode.HALF_UP);
            }
            installmentYearly = installmentMonthly.multiply(BigDecimal.valueOf(12));
            loanResultDetail.setLoanAmount(loanAmount);
            loanResultDetail.setInstallmentMonthly(installmentMonthly);
            loanResultDetail.setInstallmentYearly(installmentYearly);
            loanResultDetail.setTotalAmount(totalAmount);
            loanResultDetail.setRate(interest);

            avarageMonthly = avarageMonthly.add(loanResultDetail.getInstallmentYearly());

            details.add(loanResultDetail);
        }
        loanResult.setAvarageMontly(avarageMonthly);
        loanResult.setDetails(details);

        return loanResult;
    }
}