package com.spring5.chapter07;

public class MainProxy {
    public static void main(String[] args) {
        ExeTimeCalculator cal1 = new ExeTimeCalculator(new ImpeCalculator());
        System.out.println(cal1.factorial(20));

        ExeTimeCalculator cal2 = new ExeTimeCalculator(new RecCalculator());
        System.out.println(cal2.factorial(20));
    }
}
