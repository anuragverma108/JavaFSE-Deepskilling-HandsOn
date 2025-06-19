package com.anurag.finance;

public class ForecastCalculator {


    public static double calculateFutureValue(double principal, double rate, int years) {
        if (years == 0) {
            return principal;
        }
        return calculateFutureValue(principal * (1 + rate / 100), rate, years - 1);
    }


    public static double calculateFutureValueOptimized(double principal, double rate, int years) {
        double future = principal;
        for (int i = 0; i < years; i++) {
            future = future * (1 + rate / 100);
        }
        return future;
    }
}
