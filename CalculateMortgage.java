package com.company.yogesh;

public class CalculateMortgage {
    // Field members of the class
    final byte monthsInYear = 12;
    final byte percent = 100;

    private int principalAmount;
    private float annualInterestRate;
    private byte numberOfYears;




    public CalculateMortgage(int principalAmount, float annualInterestRate, byte numberOfYears) {
        this.principalAmount = principalAmount;
        this.annualInterestRate = annualInterestRate;
        this.numberOfYears = numberOfYears;

    }




  public double MortgagePayment(){

      float monthlyInterestRate = annualInterestRate / percent / monthsInYear;
      short numberOfPayments = (short) (monthsInYear * numberOfYears);

         double mortgageValue = principalAmount*
                    (monthlyInterestRate*Math.pow(1+monthlyInterestRate,numberOfPayments))/
                    (Math.pow(1+monthlyInterestRate,numberOfPayments)-1);


            return mortgageValue;
    }

    public double CalculateBalance(){

        float monthlyInterestRate = annualInterestRate / percent / monthsInYear;
        short numberOfPayments = (short) (monthsInYear * numberOfYears);

            double mortgageBalance = principalAmount - (principalAmount*
                    (monthlyInterestRate*Math.pow(1+monthlyInterestRate,numberOfPayments))/
                    (Math.pow(1+monthlyInterestRate,numberOfPayments)-1));

            return mortgageBalance;

    }

    public byte getNumberOfYears() {
        return numberOfYears;
    }

    public byte getMonthsInYear() {
        return monthsInYear;
    }

    public byte getPercent() {
        return percent;
    }

    public int getPrincipalAmount() {
        return principalAmount;
    }

    public void setPrincipalAmount(int principalAmount) {
        this.principalAmount = principalAmount;
    }

    public float getAnnualInterestRate() {
        return annualInterestRate;
    }

    public void setAnnualInterestRate(float annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumberOfYears(byte numberOfYears) {
        this.numberOfYears = numberOfYears;
    }

    public short getNumberOfPayments() {
        return (short) (monthsInYear * numberOfYears);
    }

    public float getMonthlyInterestRate() {
        return annualInterestRate / percent / monthsInYear;
    }






}
