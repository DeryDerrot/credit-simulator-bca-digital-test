package com.creditsimulator.factory;

import com.creditsimulator.model.LoanRequest;
import com.creditsimulator.service.CreditService;
import com.creditsimulator.service.impl.CreditServiceImpl;

public class CreditServiceFactory {

    public static CreditService getService(LoanRequest req) {
        if (req.getVehicleType().equalsIgnoreCase("mobil")) {
            return new CreditServiceImpl(8.0);
        } else {
            return new CreditServiceImpl(9.0);
        }
    }
}