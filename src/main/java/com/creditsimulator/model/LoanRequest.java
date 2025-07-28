package com.creditsimulator.model;

public class LoanRequest {
    private String vehicleType;
    private String vehicleCondition;
    private int vehicleYear;
    private long totalLoanAmount;
    private int loanTenure;
    private long downPayment;

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getVehicleCondition() {
        return vehicleCondition;
    }

    public void setVehicleCondition(String vehicleCondition) {
        this.vehicleCondition = vehicleCondition;
    }

    public int getVehicleYear() {
        return vehicleYear;
    }

    public void setVehicleYear(int vehicleYear) {
        this.vehicleYear = vehicleYear;
    }

    public long getTotalLoanAmount() {
        return totalLoanAmount;
    }

    public void setTotalLoanAmount(long totalLoanAmount) {
        this.totalLoanAmount = totalLoanAmount;
    }

    public int getLoanTenure() {
        return loanTenure;
    }

    public void setLoanTenure(int loanTenure) {
        this.loanTenure = loanTenure;
    }

    public long getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(long downPayment) {
        this.downPayment = downPayment;
    }

    @Override
    public String toString() {
        return "LoanRequest{" +
                "vehicleType='" + vehicleType + '\'' +
                ", vehicleCondition='" + vehicleCondition + '\'' +
                ", vehicleYear=" + vehicleYear +
                ", totalLoanAmount=" + totalLoanAmount +
                ", loanTenure=" + loanTenure +
                ", downPayment=" + downPayment +
                '}';
    }
}