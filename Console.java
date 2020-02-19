package com.company.yogesh;

import java.util.Scanner;

public class Console {

    public double readValues(String Caption, int max, int min){
        var inputValues = new Scanner(System.in);
        double value;
        while(true){
            System.out.println(Caption);
            value = inputValues.nextDouble();
            if(value <= min || value >= max)
                System.out.println("Enter the value between" + " " + min + " " +"and" + " "+ max);
            else
                return value;
        }

    }

}
