/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Bank;
import java.util.Scanner;
import com.mycompany.Bank.Menu;
import com.mycompany.Bank.AccountOperations;
import java.io.Console;
import java.util.logging.Logger;
/**
 *
 * @author Pramod Suthar
 */
public class BankAccount_1 {

    int option = -1;
    int index = 0;
    int accNumberSquence = 10000;
    int[] accNumberArray = new int[100];
    String[] accFirstNameArray = new String[100];
    String[] accLastNameArray = new String[100];
    String[] accTypeArray = new String[100];
    int[] accBalanceArray = new int[100];
    String[] accStatusArray = new String[100];
    int initialBalance = 0;

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public boolean validateString(String str) {
        str = str.toLowerCase();
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char ch = charArray[i];
            if (!(ch >= 'a' && ch <= 'z')) {
                return false;
            }
        }
        return true;
    }

    public void PauseTimer(int time) {
        int timer = time;
        try {
            Thread.sleep(timer * 1000);
        } catch (InterruptedException ex) {
            System.exit(0);
        }
    }

    Scanner s = new Scanner(System.in);

    public void CreateAccount() {
        boolean valid = false;
        boolean valid2 = false;
        boolean valid3 = false;
        String fName, lName;
        int tempOption = -1;
        System.out.println("======================== Welcome to the Account Creation Wizard====================================");
        PauseTimer(1);
        System.out.println("Entering the Name of the Customer. Please note that the Names must be at least 2 letters and not more than 20 letters. Also numbers and special charaters are not accepted.");
        PauseTimer(1);
        while (!valid) {
            System.out.println("Now please enter the First Name of the Customer");
            fName = s.nextLine();
            if (validateString(fName) == true) {
                fName = accFirstNameArray[index];
                valid = true;

            } else {
                System.out.println("Invalid input Please try again.");
            }

        }

        while (!valid2) {
            System.out.println("Now please enter the Last Name of the Customer");
            lName = s.nextLine();
            if (validateString(lName) == true) {
                lName = accLastNameArray[index];
                valid2 = true;

            } else {
                System.out.println("Invalid input Please try again.");
            }

        }
        while (!valid3) {
            System.out.println("Please select the type of Account:");
            System.out.println("1. Chequing Account");
            System.out.println("2. Savings Account");
            option = Integer.parseInt(s.nextLine());
            if (option == 1) {
                accTypeArray[index] = "Chequing";
                valid3 = true;
            } else if (option == 2) {
                accTypeArray[index] = "Savings";
                valid3 = true;
            } else {
                System.out.println("Invalid account type selected. Please try again.");
            }

        }

        System.out.println("Entering initial balance in the account. (Minimum amount: $10 | Maximum amount: $10000");
        PauseTimer(1);
        System.out.println("Please enter the initial amount in the Account:");
        do {
            try {
                initialBalance = Integer.parseInt(s.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number. Please try again.");
            }
            if (initialBalance < 10 || initialBalance > 10000) {
                System.out.println("Invalid amount. Please try again.");
            } else {
                accBalanceArray[index] = initialBalance;
            }
        } while (initialBalance < 10 || initialBalance > 10000);
        accNumberArray[index] = accNumberSquence;
        System.out.println("====Account Created Successfully====");
        accStatusArray[index] = "Active";
        accNumberSquence += 1;
        index += 1;
        boolean valid4 = false;
        while (!valid4) {
            System.out.println("What you want to do next?");
            System.out.println("1. Add Another Account");
            System.out.println("2. Back to Main Menu");
            option = Integer.parseInt(s.nextLine());
            if (option == 1) {

                clearScreen();
                CreateAccount();
                valid4 = true;
            } else if (option == 2) {
                clearScreen();
                Menu.main(accTypeArray);
                valid4 = true;
            } else {
                System.out.println("Invalid input. Heading back to Main Menu anyway");
                Menu m1 = new Menu();
                m1.MainMenu();
                valid4 = true;
            }
        }

    }

    public void RemoveAccount() {
        char c = '\0';
        System.out.println("======================== Welcome to the Account Remove Wizard====================================");
        System.out.println("Please enter the Account Number you want to remove?");
        int accInput = s.nextInt();
        boolean valid = false;
        for (int i = 0; i < 100; i++) {
            if (accNumberArray[i] == accInput) {
                if (accStatusArray[i] == "Terminated") {
                    System.out.println("Account already removed or terminated");
                    System.out.printf("Customer Name: %s %s", accFirstNameArray[i], accLastNameArray[i]);
                    System.out.println("\n Account number is: " + accNumberArray[i]);
                    break;
                } else {
                    System.out.println("Account Found!");
                    System.out.printf("Customer Name: %s %s", accFirstNameArray[i], accLastNameArray[i]);
                    System.out.println("\n Account number is: " + accNumberArray[i]);
                    System.out.println("Account Balance is: " + accBalanceArray[i]);

                }

                while (!valid) {
                    System.out.println("Do you want to delete account?");
                    System.out.println("Press Y to yes or N for cancel");
                    c = Character.toUpperCase(s.next().charAt(0));
                    if (c == 'Y') {
                        accStatusArray[i] = "Terminated";
                        valid = true;
                        break;
                    } else if (option == 'N') {
                        System.out.println("Remove operation terminated");
                        System.out.println("You will be sent to the main menu");
                        clearScreen();
                        valid = true;
                        break;
                    } else {
                        System.out.println("Invalid option!. Please try again! ");

                    }
                    //System.out.println("");
                }
            } else {
                System.out.println("Account not found");
                PauseTimer(1);
                while (!valid) {
                    System.out.println("Do you want to try again?");
                    System.out.println("1. Try again");
                    System.out.println("2. Back to Main Menu");
                    option = Integer.parseInt(s.nextLine());
                    if (option == 1) {

                        clearScreen();
                        RemoveAccount();

                        valid = true;
                        break;
                    } else if (option == 2) {
                        clearScreen();
                        Menu m1 = new Menu();
                        m1.MainMenu();
                        valid = true;
                        break;
                    } else {
                        System.out.println("Invalid choice. Please try again");
                    }

                }
            }
        }

    }

    public void DisplayAccount() {
        char c = '\0';
        boolean valid = false;
        System.out.println("======================== Welcome to the Display Account Wizard====================================");
        System.out.println("Please enter the Account Number you want to display?");
        int accInput = s.nextInt();
        for (int i = 0; i < 100; i++) {
            if (accNumberArray[i] == accInput) {

                System.out.println("Account Found!");
                System.out.printf("Customer Name: %s %s", accFirstNameArray[i], accLastNameArray[i]);
                System.out.println("\n Account number is: " + accNumberArray[i]);
                System.out.println("Account Status is: " + accStatusArray[i]);
                System.out.println("Account Balance is: " + accBalanceArray[i]);

            } else {
                System.out.println("Account not found");
                break;
            }
        }
        while (!valid) {
            System.out.println("Do you want to display another account?");
            System.out.println("Press Y for Yes and N for No");
            c = Character.toUpperCase(s.next().charAt(0));
            if (c == 'Y') {
                clearScreen();
                DisplayAccount();
                valid = true;
            } else if (c == 'N') {
                System.out.println("Heading back to main menu.");
                PauseTimer(1);
                Menu m1 = new Menu();
                m1.MainMenu();
                valid = true;
            } else {
                System.out.println("Invalid option. Please try again.");
            }

        }
    }

    public void ExitApp() {
        System.out.println("Thank you for using this app.");
        PauseTimer(2);
        System.exit(0);
    }

}
