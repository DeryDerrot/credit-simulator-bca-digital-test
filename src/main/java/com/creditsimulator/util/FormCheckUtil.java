package com.creditsimulator.util;

import java.util.Calendar;

public class FormCheckUtil {

    public static String vehicleTypeCheck(String vehicleType) {
        if (!vehicleType.equalsIgnoreCase("mobil") && !vehicleType.equalsIgnoreCase("motor")) {
            throw new IllegalArgumentException("Jenis kendaraan harus Motor atau Mobil");
        } else {
            return vehicleType;
        }
    }

    public static String vehicleConditionCheck(String vehicleCondition) {
        if (!vehicleCondition.equalsIgnoreCase("baru") && !vehicleCondition.equalsIgnoreCase("bekas")) {
            throw new IllegalArgumentException("Tipe kendaraan harus Baru atau Bekas");
        } else {
            return vehicleCondition;
        }
    }

    public static int vehicleYearCheck(int vehicleYear, String vehicleCondition) {
        Calendar calendar = Calendar.getInstance();
        int currentYear = calendar.get(Calendar.YEAR);

        if (vehicleYear > currentYear) {
            throw new IllegalArgumentException("Tidak boleh mengisi melebihi tahun saat ini");
        }

        if (vehicleCondition.equalsIgnoreCase("baru")) {
            if (vehicleYear == (currentYear - 1) || vehicleYear == (currentYear)) {
                return vehicleYear;
            } else {
                throw new IllegalArgumentException("Jika kondisi kendaraan Baru harus dibawah 1 tahun dari tahun saat ini");
            }
        } else {
            return vehicleYear;
        }
    }

    public static int tenorCheck(int tenor) {
        if (tenor < 1 || tenor > 6) {
            throw new IllegalArgumentException("Tenor tidak boleh kurang dari 1 tahun atau lebih dari 6 tahun");
        }
        return tenor;
    }

    public static long downPaymentCheck(long downPayment, long totalLoanAmount, String conditionType) {

        long minimumDp = 0L;

        if (conditionType.equalsIgnoreCase("baru")) {
            minimumDp = (totalLoanAmount * 35) / 100;
        } else if (conditionType.equalsIgnoreCase("bekas")) {
            minimumDp = (totalLoanAmount * 25) / 100;
        }

        if (totalLoanAmount != 0 && downPayment < minimumDp) {
            throw new IllegalArgumentException("Downpayment minimum jika Mobil/Motor kondisi baru 35% atau kondisi lam 25%");
        }
        return downPayment;
    }
}
