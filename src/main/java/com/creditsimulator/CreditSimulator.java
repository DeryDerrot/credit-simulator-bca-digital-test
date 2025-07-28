package com.creditsimulator;

import com.creditsimulator.controller.CreditController;

public class CreditSimulator {

    public static void main(String[] args) {
        CreditController controller = new CreditController();

        if (args.length > 0) {
            controller.processFile(args[0]);
        } else {
            controller.interactiveMode();
        }
    }
}