package com.pluralsight;

import java.util.Scanner;

public class FinancialCalculators {

    public static void main(String[] args) {
        // home screen that prompts user to pick the calculator they would like to use
        System.out.println("Please select which calculator you would like to use:\n" +
                "1. Mortgage calculator\n" +
                "2. Future value of a one-time deposit assuming compound interest calculator\n" +
                "3. Present value of an ordinary annuity calculator\n" +
                "**Enter the digit corresponding with the desired calculator**");

        //initializing a scanner and a choice variable to get user input

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        //switch statement that takes the corresponding user response and directs them to the calculator/method needed
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
                System.out.println("Invalid entry, please try again.");
        }
    }

    //mortgage calculator
    public static void mortgageCalculator(Scanner scanner) {
        //getting the known values
        System.out.println("Please enter the principal: ");
        double principal = scanner.nextDouble();

        System.out.println("Please enter the interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Please enter the loan length: ");
        double loanLength = scanner.nextDouble();

        //initializing variables needed for the equations using user data
        double annualInterestRate = interestRate * 0.01;
        double numMonthlyPayments = loanLength * 12;
        double monthlyInterestRate = annualInterestRate / 12;

        //initializing the variables that calculate the result
        double monthlyPayment = principal * (monthlyInterestRate * (Math.pow(1+monthlyInterestRate, numMonthlyPayments)) / ((Math.pow(1 + monthlyInterestRate, numMonthlyPayments))-1));
        double totalInterest = (monthlyPayment * numMonthlyPayments) - principal;

        //printing the result
        System.out.printf("A $%.0f loan at %.2f interest for %.0f years would have a $%.2f/mo payment with a total " +
                "interest of $%.2f.", principal, interestRate, loanLength, monthlyPayment, totalInterest);
    }

    //future value of a one-time deposit assuming compound interest calculator
    public static void futureValueCalculator(Scanner scanner) {
        //getting the known values
        System.out.println("Please enter the deposit: ");
        double deposit = scanner.nextDouble();

        System.out.println("Please enter the interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years: ");
        double numYears = scanner.nextDouble();

        //initializing variables needed for the equations using user data
        double annualInterestRate = interestRate * 0.01;
        double numOfDays = numYears * 365;

        //initializing the variables that calculate the result
        double futureValue = deposit * ((Math.pow(1 +( annualInterestRate / 365), numOfDays)));
        double totalInterestEarned = futureValue - deposit;

        //printing the result
        System.out.printf("If you deposit %.0f in a CD that earns %.2f interest and matures in %.0f years, your CD's ending balance will be $%.2f and " +
                "you would have earned $%.2f in interest.", deposit, interestRate, numYears, futureValue, totalInterestEarned);
    }

    //Present value of an ordinary annuity calculator
    public static void presentValueCalculator(Scanner scanner) {
        //getting the known values
        System.out.println("Please enter the monthly payout: ");
        double monthlyPayout = scanner.nextDouble();

        System.out.println("Please enter the expected interest rate: ");
        double interestRate = scanner.nextDouble();

        System.out.println("Please enter the number of years to pay out: ");
        double numYears = scanner.nextDouble();

        //initializing variables needed for the equations using user data
        double annualInterestRate = interestRate * 0.01;
        double numOfPeriods = 12 * numYears;
        double periodInterestRate = annualInterestRate / 12;

        //initializing the variable that calculates the result
        double valueOfAnnuity = monthlyPayout * ((1-(Math.pow( 1 + periodInterestRate, -numOfPeriods))) / periodInterestRate);

        //printing the result
        System.out.printf("To fund an annuity that pays %.0f monthly for %.0f years and earns an expected %.2f interest, you would need " +
                "to invest $%.2f today.", monthlyPayout, numYears, interestRate, valueOfAnnuity);
    }
}
