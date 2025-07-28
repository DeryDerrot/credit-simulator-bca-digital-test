package com.creditsimulator.model;

import java.math.BigDecimal;
import java.util.List;

public class LoanResult {

    private long vehiclePrice;
    private long downPayment;
    private BigDecimal avarageMontly;
    private int tenor;
    private List<LoanResultDetail> details;

    public long getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(long vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    public long getDownPayment() {
        return downPayment;
    }

    public void setDownPayment(long downPayment) {
        this.downPayment = downPayment;
    }

    public BigDecimal getAvarageMontly() {
        return avarageMontly;
    }

    public void setAvarageMontly(BigDecimal avarageMontly) {
        this.avarageMontly = avarageMontly;
    }

    public int getTenor() {
        return tenor;
    }

    public void setTenor(int tenor) {
        this.tenor = tenor;
    }

    public List<LoanResultDetail> getDetails() {
        return details;
    }

    public void setDetails(List<LoanResultDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "LoanResult{" +
                "hargaKendaraan=" + vehiclePrice +
                ", downPayment=" + downPayment +
                ", avarageMontly=" + avarageMontly +
                ", tenor=" + tenor +
                ", details=" + details +
                '}';
    }
}