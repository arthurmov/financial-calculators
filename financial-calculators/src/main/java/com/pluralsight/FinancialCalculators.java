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
            default:
                System.out.println("Invalid Entry, please run the program again.");
        }
    }

    public static void mortgageCalculator(Scanner scanner) {

        System.out.println("Please enter the principal: ");
        double principal = scanner.nextDouble();

        System.out.println("Please enter the interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Please enter the loan length: ");
        double loanLength = scanner.nextDouble();

        double annualInterestRate = interestRate * 0.01;
        double numMonthlyPayments = loanLength * 12;
        double monthlyInterestRate = annualInterestRate / 12;

        double monthlyPayment = principal * (monthlyInterestRate * (Math.pow(1+monthlyInterestRate, numMonthlyPayments)) / ((Math.pow(1 + monthlyInterestRate, numMonthlyPayments))-1));
        double totalInterest = (monthlyPayment * numMonthlyPayments) - principal;

        System.out.printf("A $%.0f loan at %.2f interest for %.0f years would have a $%.2f/mo payment with a total " +
                "interest of $%.2f.", principal, interestRate, loanLength, monthlyPayment, totalInterest);
    }

    public static void futureValueCalculator(Scanner scanner) {

    }

    public static void presentValueCalculator(Scanner scanner) {

    }
}
