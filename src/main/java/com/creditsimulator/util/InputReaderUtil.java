package com.creditsimulator.util;

import com.creditsimulator.model.LoanRequest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InputReaderUtil {

    public static LoanRequest inputManually(Scanner scanner) {
        LoanRequest request = new LoanRequest();
        System.out.println("Please enter fill the form: ");

        System.out.println("Vehicle Type (Motor/Mobil) : ");
        String vehicleType = FormCheckUtil.vehicleTypeCheck(scanner.nextLine());
        request.setVehicleType(vehicleType);

        System.out.println("Vehicle Condition (Bekas/Baru) : ");
        String vehicleCondition = FormCheckUtil.vehicleConditionCheck(scanner.nextLine());
        request.setVehicleCondition(vehicleCondition);

        System.out.println("Vehicle Year : ");
        int vehicleYear = FormCheckUtil.vehicleYearCheck(scanner.nextInt(), vehicleCondition);
        request.setVehicleYear(vehicleYear);

        System.out.println("Total Loan Amount : ");
        long totalLoanAmount = scanner.nextInt();
        request.setTotalLoanAmount(totalLoanAmount);

        System.out.println("Tenor : ");
        int tenor = FormCheckUtil.tenorCheck(scanner.nextInt());
        request.setLoanTenure(tenor);

        System.out.println("Down Payment : ");
        long dp = FormCheckUtil.downPaymentCheck(scanner.nextInt(), totalLoanAmount, vehicleCondition);
        request.setDownPayment(dp);

        return request;
    }

    public static LoanRequest readFile(String filename) {
        try {
            String[] lines = Files.readString(Path.of(filename)).split("\n");
            LoanRequest req = new LoanRequest();

            String vehicleType = FormCheckUtil.vehicleTypeCheck(lines[0]);
            req.setVehicleType(vehicleType);

            String vehicleCondition = FormCheckUtil.vehicleConditionCheck(lines[1]);
            req.setVehicleCondition(vehicleCondition);

            int vehicleYear = FormCheckUtil.vehicleYearCheck(Integer.parseInt(lines[2]), vehicleCondition);
            req.setVehicleYear(vehicleYear);

            long totalLoanAmount = Long.parseLong(lines[3]);
            req.setTotalLoanAmount(totalLoanAmount);

            int tenor = FormCheckUtil.tenorCheck(Integer.parseInt(lines[4]));
            req.setLoanTenure(tenor);

            long dp = FormCheckUtil.downPaymentCheck(Long.parseLong(lines[5]), totalLoanAmount, vehicleCondition);
            req.setDownPayment(dp);

            return req;
        } catch (IOException | NumberFormatException e) {
            throw new RuntimeException("Invalid file input.", e);
        }
    }
}