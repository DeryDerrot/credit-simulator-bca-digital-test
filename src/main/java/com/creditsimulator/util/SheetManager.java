package com.creditsimulator.util;

import com.creditsimulator.model.LoanRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SheetManager {
    private final Map<String, LoanRequest> sheets = new HashMap<>();
    private LoanRequest current;

    public LoanRequest saveCurrent() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sheet name: ");
        String name = scanner.nextLine();
        current = InputReaderUtil.inputManually(scanner);
        sheets.put(name, current);

        System.out.println("Sheet saved as '" + name + "'");
        return current;
    }

    public LoanRequest switchSheet(Scanner sc) {
        System.out.print("Sheet name: ");
        String name = sc.nextLine();
        if (sheets.containsKey(name)) {
            current = sheets.get(name);
            System.out.println("Switched to sheet '" + name + "'");
            return current;
        } else {
            System.out.println("Sheet not found.");
            return null;
        }
    }

    public void printSheets() {
        if (sheets.size() > 0) {
            for (Map.Entry<String, LoanRequest> entry : sheets.entrySet()) {
                System.out.println("============================");
                System.out.println("sheet name: ");
                System.out.println(entry.getKey());
                System.out.println("============================");
            }
        } else {
            System.out.println("No sheets found.");
        }
    }

    public void setCurrent(LoanRequest req) {
        this.current = req;
    }
}