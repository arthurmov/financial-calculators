package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Please select which calculator you would like to use:\n" +
                "1. Mortgage Calculator\n" +
                "2. Future Value Calculator\n" +
                "3. Present Value Calculator\n" +
                "**Enter the digit corresponding with the desired calculator**");

        int choice = scanner.nextInt();
        double output = 0;

        if (choice == 1) {
            output = mortgageCalculator();
        } else if (choice == 2) {
            output = futureValueCalculator();
        } else if (choice == 3) {
            output = presentValueCalculator();
        } else System.out.println("Invalid entry, please run the program again.");

    }

    public static double mortgageCalculator() {

    }

    public static double futureValueCalculator() {

    }

    public static double presentValueCalculator() {

    }
}
