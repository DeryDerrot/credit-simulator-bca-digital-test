package com.creditsimulator.model;

import java.math.BigDecimal;

public class LoanResultDetail {

    private BigDecimal loanAmount;
    private BigDecimal rate;
    private BigDecimal totalAmount;
    private BigDecimal installmentMonthly;
    private BigDecimal installmentYearly;

    public BigDecimal getLoanAmount() {
        return loanAmount;
    }

    public void setLoanAmount(BigDecimal loanAmount) {
        this.loanAmount = loanAmount;
    }

    public BigDecimal getRate() {
        return rate;
    }

    public void setRate(BigDecimal rate) {
        this.rate = rate;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getInstallmentMonthly() {
        return installmentMonthly;
    }

    public void setInstallmentMonthly(BigDecimal installmentMonthly) {
        this.installmentMonthly = installmentMonthly;
    }

    public BigDecimal getInstallmentYearly() {
        return installmentYearly;
    }

    public void setInstallmentYearly(BigDecimal installmentYearly) {
        this.installmentYearly = installmentYearly;
    }

    @Override
    public String toString() {
        return "LoanResultDetail{" +
                "loanAmount=" + loanAmount +
                ", rate=" + rate +
                ", totalAmount=" + totalAmount +
                ", installmentMonthly=" + installmentMonthly +
                ", installmentYearly=" + installmentYearly +
                '}';
    }
}
