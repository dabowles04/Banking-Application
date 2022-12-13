/**
 * Author: David Bowles
 * File: BankApplication.java
 * Description: This BankApplication.java file is a banking application menu
 * with 4 actions the user can select: 
 * 										
 * 1. Deposit 
 * 2. View Daily Interest Rate
 * 3. View Account Details
 * 4. Exit
 * 
 */

import java.util.Scanner;

// Bank Application class
public class BankApplication {
	
	// Main method
	public static void main(String[] args) {
		
		// Create checking account object
		CheckingAccount acct1 = new CheckingAccount();
		
		// Open Scanner object
		Scanner input = new Scanner(System.in);
		
		// Variables
		String acctID;
		double balance;
		double interestRate;
		String dateAcctCreated;
		
		// Do/while input validation loop for ID
		do {
			System.out.print("Enter unique ID: ");
			acctID = input.next();
			
			// If greater than or equal to 4, Set ID
			if(acctID.length() >= 4) {
				acct1.setUniqueID(acctID);
			}
			else {
				System.out.println("!!!ERROR: unique IDs are at least 4 characters long!!!");
			}
		}
		while (!(acctID.length() >= 4));
		
		
		// Do/while Input Validation loop for balance
		do {
			System.out.print("Enter the initial balance: $");
			balance = input.nextDouble();
			
			if (balance >= 500) {
				acct1.setAcctBalance(balance);
			}
			else {
				System.out.println("!!!ERROR" + 
						" New Accounts need a balance of at least $500!!!");
			}
		}
		while(!(balance >= 500));
		
		// Prompt user for annual interest rate and store as 
		System.out.print("Enter annual interest rate as a percentage: ");
		interestRate = input.nextDouble();
		acct1.setAnnualInterestRate(interestRate);
		
		// Set Date created
		java.util.Date date = new java.util.Date();
		dateAcctCreated = date.toString();
		acct1.setDateCreated(dateAcctCreated);
		
		// User input integer variable
		int userAnswer;
		
		// Do/while for application menu loop after account is created
		do {
			// Display menu
			System.out.println("=============================");
			System.out.println("=           OPTIONS 	    =");
			System.out.println("=============================");
			System.out.println("1. Deposit");
			System.out.println("2. View Daily Interest Rate");
			System.out.println("3. View Account Details");
			System.out.println("4. Exit");
			System.out.println("----------------------");
			System.out.println("Enter your selection");
			userAnswer = input.nextInt();
			
			// Input validation for user menu selection
			while (userAnswer > 4 || userAnswer < 1) {
				System.out.println("INVALID SELECTION - TRY AGAIN!");
				userAnswer = input.nextInt();
			}
			
			// Cases for the application menu
			switch (userAnswer) {
			
			// Case 1 for depositing cash
			  case 1: 
				  
				  System.out.println("Enter your deposit amount: ");
				  double depositAmount = input.nextDouble();
				  
				  // Deposits must be greater than $0
				  while (!(depositAmount > 0)) {
					  System.out.println("!!!ERROR: Deposits must be greater than $0!!!");
					  System.out.println("Enter your deposit amount: ");
					  depositAmount = input.nextDouble();
				  }
				    
				  double newbalance = acct1.depositCash(depositAmount);
				  System.out.println();
				  System.out.printf("New Balance: $" + "%.2f", newbalance);
				  System.out.print("\n");
				  
				  break;
				  
			// Case 2 for daily interest rate/amount info	  
			  case 2:
				  
				  
				  System.out.println();
				  System.out.println("Your Daily Interest Rate is: ");
				  System.out.println(interestRate + "%");
				  System.out.println("Your Daily Interest Amount is: ");
				  System.out.printf("$ " + "%.2f", ((acct1.getAcctBalance() * (acct1.getDailyIntRate(interestRate) / 365))));
				  System.out.print("\n");
				  
				  break;
				  
			// Case 3 for account information	  
			  case 3: 
				  
				  // Display account information
				  System.out.println("Account Unique ID: " + acct1.getUniqueID());
				  System.out.println("Account Creation Date/Time: " + acct1.getDateCreated());
				  System.out.println("Balance: " + acct1.getAcctBalance());
				  System.out.println("Daily Interest Amount: ");
				  System.out.printf("$ " + "%.2f", (acct1.getAcctBalance() * (acct1.getDailyIntRate(interestRate) / 365)));
				  System.out.print("\n");
				  
				  break;
				  
			// Case 4 to end program	  
			  case 4: 
				  
				  System.out.println();
				  System.out.println("Program exiting...");
				  
				  System.exit(0);
			}
		}
		while (userAnswer != 4);
		
		// Close Scanner object
		input.close();
		
	}
}
