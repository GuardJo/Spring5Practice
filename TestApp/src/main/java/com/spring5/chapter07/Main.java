package com.spring5.chapter07;

public class Main {
    public static void main(String[] args) {
        ImpeCalculator impeCalculator = new ImpeCalculator();
        long start1 = System.currentTimeMillis();
        long result1 = impeCalculator.factorial(4);
        long end1 = System.currentTimeMillis();
        System.out.printf("ImpeCalculator.factorial(4) Execution Time = %d\n", (end1 - start1));

        RecCalculator recCalculator = new RecCalculator();
        long start2 = System.currentTimeMillis();
        long result2 = recCalculator.factorial(4);
        long end2 = System.currentTimeMillis();
        System.out.printf("RecCalculator.factorial(4) Execution Time = %d\n", (end2 - start2));
    }
}
