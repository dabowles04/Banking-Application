/**
 * Author: David Bowles
 * File: CheckingAccount.java
 * Description: This CheckingAccount.java file is for accessing user information
 * in BankApplication.java file
 * 
 */


// Checking account class
public class CheckingAccount {

	// Data fields for account information
	private String uniqueID;
	private double acctBalance;
	private double annualInterestRate;
	private String dateCreated;
	
	// Constructors
	public CheckingAccount() {
		
	}

	public CheckingAccount(String uniqueID, double acctBalance, double annualInterestRate, String dateCreated) {
		super();
		this.uniqueID = uniqueID;
		this.acctBalance = acctBalance;
		this.annualInterestRate = annualInterestRate;
		this.dateCreated = dateCreated;
	}
	

//--------------------------------------------------------
	
	// Getters
	public String getUniqueID() {
		return uniqueID;
	}

	public double getAcctBalance() {
		return acctBalance;
	}

	public double getAnnualInterestRate() {
		return annualInterestRate;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	
	// Setters
	public void setUniqueID(String uniqueID) {
		this.uniqueID = uniqueID;
	}

	public void setAcctBalance(double acctBalance) {
		this.acctBalance = acctBalance;
	}

	public void setAnnualInterestRate(double annualInterestRate) {
		this.annualInterestRate = annualInterestRate;
	}
	
	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	// toString method to print object contents
	@Override
	public String toString() {
		return "CheckingAccount [uniqueID=" + uniqueID + ", acctBalance=" + acctBalance + ", annualInterestRate="
				+ annualInterestRate + ", dateCreated=" + dateCreated + "]";
	}
	
//--------------------------------------------------------
	// Methods
	
	// depositCash method returns balance after user deposits cash
	public double depositCash(double cash) {
		return (this.acctBalance += cash);
	}
	
	// getDailyIntRate method returns daily interest rate
	public double getDailyIntRate(double rate) {
		return (this.annualInterestRate / 100);
		
	}
	
}
