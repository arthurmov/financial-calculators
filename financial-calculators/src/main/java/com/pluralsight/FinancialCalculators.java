package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {

    public static void main(String[] args) {

        System.out.println("Please select which calculator you would like to use:\n" +
                "1. Mortgage calculator\n" +
                "2. Future value of a one-time deposit assuming compound interest calculator\n" +
                "3. Present value of an ordinary annuity calculator\n" +
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

        System.out.println("Please enter the deposit: ");
        double deposit = scanner.nextDouble();

        System.out.println("Please enter the interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years: ");
        double numYears = scanner.nextDouble();

        double annualInterestRate = interestRate * 0.01;
        double numOfDays = numYears * 365;

        double futureValue = deposit * ((Math.pow(1 +( annualInterestRate / 365), numOfDays)));
        double totalInterestEarned = futureValue - deposit;

        System.out.printf("If you deposit %.0f in a CD that earns %.2f interest and matures in %.0f years, your CD's ending balance will be $%.2f and " +
                "you would have earned $%.2f in interest.", deposit, interestRate, numYears, futureValue, totalInterestEarned);
    }

    public static void presentValueCalculator(Scanner scanner) {
        System.out.println("Please enter the monthly payout: ");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("Please enter the expected interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years to pay out: ");
        double numYears = scanner.nextDouble();

        double annualInterestRate = interestRate * 0.01;
        double numOfPeriods = 12 * numYears;
        double periodInterestRate = annualInterestRate / 12;

        double valueOfAnnuity = monthlyPayout * ((1-(Math.pow( 1 + periodInterestRate, -numOfPeriods))) / periodInterestRate);

        System.out.printf("To fund an annuity that pays %.0f monthly for %.0f years and earns an expected %.2f interest, you would need " +
                "to invest $%.2f today.", monthlyPayout, numYears, interestRate, valueOfAnnuity);
    }
}
