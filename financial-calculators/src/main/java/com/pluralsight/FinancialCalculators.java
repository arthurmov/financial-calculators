package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {

    public static void main(String[] args) {

        System.out.println("Please select which calculator you would like to use:\n" +
                "1. Mortgage Calculator\n" +
                "2. Future Value Calculator\n" +
                "3. Present Value Calculator\n" +
                "**Enter the digit corresponding with the desired calculator**");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                mortgageCalculator(scanner);
                break;
            case 2:
                futureValueCalculator(scanner);
                break;
            case 3:
                presentValueCalculator(scanner);
            default: System.out.println("Invalid Entry, please run the program again.");
        }
    }

    public static void mortgageCalculator(Scanner scanner) {

    }

    public static void futureValueCalculator(Scanner scanner) {

    }

    public static void presentValueCalculator(Scanner scanner) {

    }
}
