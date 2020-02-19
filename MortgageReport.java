package com.company.yogesh;


import java.text.NumberFormat;

public class MortgageReport {

  private CalculateMortgage calculator;

  public MortgageReport(CalculateMortgage calculator) {
        this.calculator = calculator;
  } // Constructor

    public void PaymentReport(){
        double mortgageReport = calculator.MortgagePayment();
        System.out.println("mortgageReport " + mortgageReport);
        String mortgageformatted = NumberFormat.getCurrencyInstance().format(mortgageReport);
        System.out.println();
        System.out.println("Mortgage_Payment Report");
        System.out.println("**************************************");
        System.out.println("The Monthly Payments:" + mortgageformatted);

    }

    public void PaymentBalance(){

        System.out.println();
        System.out.println("Mortgage_Payment Balance each month");
        System.out.println("**************************************************");
        double mortgageBalance = calculator.CalculateBalance();
        System.out.println(NumberFormat.getCurrencyInstance().format(mortgageBalance));

        for(short month = 1; month <= calculator.getNumberOfYears() * calculator.monthsInYear; month++) {
             mortgageBalance -= calculator.MortgagePayment();
             if(mortgageBalance < 0){
                 System.out.println(0);
                 break;
             }
            System.out.println(NumberFormat.getCurrencyInstance().format(mortgageBalance));

        }
    }

}
