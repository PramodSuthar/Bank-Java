/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.Bank;
import com.mycompany.Bank.BankAccount_1;
import java.util.Scanner;

/**
 *
 * @author Pramod Suthar
 */
public class AccountOperations extends BankAccount_1 {
    Scanner s = new Scanner(System.in);
    boolean valid = false;
    BankAccount b1 = new BankAccount();
    int depositAmount = 0;
    int withdrawAmount = 0;
    int a = 0;
    int nwAccnt = 0;
    double total = 0;
    double average = 0;

    public void WithdrawAmount() {
        boolean valid = false;
        clearScreen();
        System.out.println("========================Welcome to the Amount Balance Withdraw Wizard==================================");
        PauseTimer(1);
        System.out.println("Select the account you want to Withdraw Amount from");
        int accInput = s.nextInt();
        for (int i = 0; i < 100; i++) {
            if (accNumberArray[i] == accInput) {

                System.out.println("Account Found!");
                System.out.printf("Customer Name: %s %s", accFirstNameArray[i], accLastNameArray[i]);
                System.out.println("\n Account number is: " + accNumberArray[i]);
                System.out.println("Account Status is: " + accStatusArray[i]);
                System.out.println("Account Balance is: " + accBalanceArray[i]);
                System.out.println("Withdrawing Amount from the Account");
                System.out.println("Note: The minimum amount you can withdraw is $10. Also ,The amount also should be multiple of 10 ");
                PauseTimer(1);
                System.out.println("Please enter the amount you want to withdraw:");
                do {
                    try {
                        withdrawAmount = Integer.parseInt(s.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Not a valid number. Please try again.");
                    }
                    if (withdrawAmount < 10 || withdrawAmount > 10000 || withdrawAmount % 10 != 0) {
                        System.out.println("Invalid amount or Amount not a multiple of 10. Please try again.");
                    } else {
                        accBalanceArray[i] -= withdrawAmount;
                    }
                } while (withdrawAmount < 10 || withdrawAmount > 10000);
                System.out.println("====Amount Withdrawn Successfully====");
                PauseTimer(1);
                while (!valid) {
                    System.out.println("What you want to do next?");
                    System.out.println("1. Withdraw from another Account");
                    System.out.println("2. Back to Main Menu");
                    a = Integer.parseInt(s.nextLine());
                    if (a == 1) {
                        WithdrawAmount();
                        valid = true;
                    } else if (a == 2) {
                        Menu m1 = new Menu();
                        m1.MainMenu();
                        valid = true;
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }

                }
            }
        }
    }

    public void DepositAmount() {
        System.out.println("========================Welcome to the Amount Balance Deposit Wizard==================================");
        PauseTimer(1);
        System.out.println("Select the account you want to Deposit Amount to");
        int accInput = s.nextInt();
        boolean valid = false;
        for (int i1 = 0; i1 < 100; i1++) {
            if (accNumberArray[i1] == accInput) {

                System.out.println("Account Found!");
                System.out.printf("Customer Name: %s %s", accFirstNameArray[i1], accLastNameArray[i1]);
                System.out.println("\n Account number is: " + accNumberArray[i1]);
                System.out.println("Account Status is: " + accStatusArray[i1]);
                System.out.println("Account Balance is: " + accBalanceArray[i1]);
                System.out.println("Enter the amount you want to deposit");
                System.out.println("Deposit Amount . (Minimum amount: $10 | Maximum amount: $10000)");
                PauseTimer(1);
                while (!valid) {
                    System.out.println("Please enter the amount you want to deposit:");
                    depositAmount = Integer.parseInt(s.nextLine());
                    if (depositAmount > 10 && depositAmount < 10000) {
                        accBalanceArray[i1] += depositAmount;
                        valid = true;
                    } else {
                        System.out.println("Invalid option. Please try again.");
                    }

                    System.out.println("====Amount Deposited Successfully====");
                    System.out.println("What you want to do next?");
                    System.out.println("1. Deposit to another Account");
                    System.out.println("2. Back to Main Menu");
                    boolean valid1 = false;
                    while (!valid1) {
                        System.out.println("Please enter the amount you want to deposit:");
                        System.out.println("1. Deposit to another Account");
                        System.out.println("2. Back to Main Menu");
                        a = Integer.parseInt(s.nextLine());
                        if (a == 1) {
                            DepositAmount();
                            valid1 = true;
                        } else if (a == 2) {
                            Menu m1 = new Menu();
                            m1.MainMenu();
                            valid1 = true;
                        } else {
                            System.out.println("Invalid option. Please try again.");
                        }

                    }
                }
            }
        }
    }

    public void AverageSumAccount(int choice) {
        boolean valid = false;
        System.out.println("=======================Welcome to the Bank Summary Wizard=========================");
        for (int i = 0; i < accNumberArray.length; i++) {
            total += total + accBalanceArray[i];
        }
        average = total / accNumberArray.length;
        while (!valid) {
            System.out.println("Please select from the following: ");
            System.out.println("1. Display the sum of all the Accounts");
            System.out.println("2. Display the Average amount of all the accounts ");
            choice = Integer.parseInt(s.nextLine());
            if (choice == 1) {
                System.out.println("The total Sum amount of all the Accounts is as follows: ");
                System.out.println("The number of accounts = " + accNumberArray.length);
                System.out.println("The total amount on all Accounts: $" + total);
                valid = true;
            } else if (choice == 2) {
                System.out.println("The total Average amount of all the Accounts is as follows: ");
                System.out.println("The number of accounts = " + accNumberArray.length);
                System.out.println("The average amount on all Accounts: $" + average);
                valid = true;
            } else {
                System.out.println("Invalid option. Please try again.");
            }

        }
    }
    void SortAccount() {
        for (int pass = 1; pass < nwAccnt; pass++) {
            boolean testControl = false;
            //ASCENDING ORDER
            for (int index = 0; index < nwAccnt - 1; index++) {
                if (accBalanceArray[index] > accBalanceArray[index + 1]) {
                    int temp = accBalanceArray[index];
                    accBalanceArray[index] = accBalanceArray[index + 1];
                    accBalanceArray[index + 1] = temp;
                    testControl = true;
                }
            }
            if (testControl == false) {
                System.out.println("\n\nPass is " + pass);
                break;
            }

        } //To change body of generated methods, choose Tools | Templates.
    }


}