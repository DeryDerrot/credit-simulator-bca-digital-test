package com.creditsimulator.controller;

import com.creditsimulator.factory.CreditServiceFactory;
import com.creditsimulator.model.LoanRequest;
import com.creditsimulator.model.LoanResult;
import com.creditsimulator.service.CreditService;
import com.creditsimulator.util.InputReaderUtil;
import com.creditsimulator.util.SheetManager;

import java.util.Scanner;

public class CreditController {

    public void interactiveMode() {
        Scanner scanner = new Scanner(System.in);
        SheetManager sheetManager = new SheetManager();

        while (true) {
            System.out.println("Show all menu options type (1) : ");

            String menuOption = scanner.nextLine().trim();
            switch (menuOption) {
                case "1" -> {
                    System.out.println("[Menu]");
                    System.out.println("1.Show");
                    System.out.println("2.Input Manually");
                    System.out.println("3.Save sheet");
                    System.out.println("4.Switch sheet");
                    System.out.println("5.Print sheet");
                    System.out.println("6.Exit");
                }
                case "2" -> handleInput(InputReaderUtil.inputManually(scanner));
                case "3" -> handleInput(sheetManager.saveCurrent());
                case "4" -> handleInput(sheetManager.switchSheet(scanner));
                case "5" -> sheetManager.printSheets();
                case "6" -> System.exit(0);
                default -> System.out.println("invalid option");
            }
        }
    }

    public void processFile(String filename) {
        LoanRequest request = InputReaderUtil.readFile(filename);
        handleInput(request);
    }

    public void handleInput(LoanRequest request) {
        CreditService service = CreditServiceFactory.getService(request);
        LoanResult result = service.calculateCredit(request);
        System.out.println("========== RESULT ==========");
        System.out.println(result);
        System.out.println("============================");
    }
}