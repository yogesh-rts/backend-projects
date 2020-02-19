package com.company.yogesh;


public class MortagageCalculator {

    public static void main(String[] args) {
        var scanner = new Console();
        int principalAmount = (int) scanner.readValues("Principal Amount:",10000000,100 );
        float annualInterestRate = (float) scanner.readValues("Annual Interest Rate:", 8, 0);
        byte numberOfYears = (byte) scanner.readValues("number of Years:", 10,2);

        var calculator = new CalculateMortgage(principalAmount,annualInterestRate,numberOfYears);
        var report = new MortgageReport(calculator);

        report.PaymentReport();
        report.PaymentBalance();








    }
}
