package com.anurag.finance;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("📊 Financial Forecasting Tool\n");

        System.out.print("Enter initial amount (₹): ");
        double principal = sc.nextDouble();

        System.out.print("Enter annual growth rate (%): ");
        double rate = sc.nextDouble();

        System.out.print("Enter number of years: ");
        int years = sc.nextInt();

        double resultRecursive = ForecastCalculator.calculateFutureValue(principal, rate, years);
        double resultOptimized = ForecastCalculator.calculateFutureValueOptimized(principal, rate, years);

        System.out.println("\n🔁 Recursive Prediction: ₹" + String.format("%.2f", resultRecursive));
        System.out.println("⚡ Optimized Prediction: ₹" + String.format("%.2f", resultOptimized));
    }
}
