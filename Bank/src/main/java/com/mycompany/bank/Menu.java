/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.Bank;
import com.mycompany.Bank.BankAccount_1;
import com.mycompany.Bank.AccountOperations;
import java.util.Scanner;
/**
 *
 * @author Pramod Suthar
 */
public class Menu extends AccountOperations {
    AccountOperations a1 = new AccountOperations();
    BankAccount b1 = new BankAccount();
    int balance;
    int previousTransaction;
    String customerName;
    String customerId;
     
    void showHeader()
    {
        System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
        System.out.println("~|        Welcome to          |~");
        System.out.println("~|         ABC Bank           |~");
        System.out.println("+~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~+");
    }
        
    
    void showMenu()
    {
        int option=0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select the option to continue: ");
        System.out.println("\n");
        System.out.println("1. Add a Bank Account");
        System.out.println("2. Remove a Bank Account");
        System.out.println("3. Display a Bank Account");
        System.out.println("4. Deposit Amount into an account");
        System.out.println("5. Withdraw Amount from an account");
        System.out.println("6. Sort and display list of client ");
        System.out.println("7. Display average balance value of all accounts");
        System.out.println("8. Display the total balance value of all accounts");
        System.out.println("9. Exit");
        
        do
        {
            System.out.println("======================================================================");
            System.out.println("Enter an option: ");
            try{
                option = scanner.nextInt();
            }
            catch(NumberFormatException e){
                System.out.println("Invalid slection. Numbers only please");
            }
            if(option < 1 || option > 9){
                System.out.println("Invalid option. Please try again.");
            }
        }while (option <1 || option >9);    
        switch(option) {
            
                case 1:
                    b1.CreateAccount();
                    break;
                    
                case 2:
                    b1.RemoveAccount();
                    break;
                    
                case 3:
                    b1.DisplayAccount();
                    break;
                    
                case 4:
                    a1.DepositAmount();
                    break;
                    
                case 5:
                    a1.WithdrawAmount();
                    break;
                    
                case 6:
                    a1.SortAccount();
                    break;
                    
                case 7:
                    a1.AverageSumAccount(1);
                    break;
                    
                case 8:
                    a1.AverageSumAccount(2);
                    break;
                    
                case 9:
                    a1.ExitApp();
                
                default:
                    System.out.println("Invalid Option!!. Please try again!");
                    break;
            }
        }
        
    
   public void MainMenu(){
       showHeader();
       showMenu();
}
   public static void main(String[] args) {
       Menu m1 = new Menu();
       m1.MainMenu();
    }
}