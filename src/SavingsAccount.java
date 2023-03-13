import java.lang.StringBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
* 
* @CSavingsAccount: is the Constructor that will store the balance for our checking account and has transaction fees.
* @balance: is the double number that will be used during the different transactions.
* @Deposit: will add a double entered by the user to be added to the constructor BankAccount.
* @Withdraw:will deduce an amount entere by the user provided that the user sill has funds in the constructor BankAccount.
* @author Mark Ofosu, Andres Cheung
* @date 04/23/2021
*/
public class SavingsAccount extends BankAccount {
	  private double interestRate;
	StringBuilder history;
	
	public SavingsAccount() {
		interestRate = 20;
		history = new StringBuilder();
	}
	
	public double calculateInterest() {
		return balance*(0.1);
	}
	 
	
	public void applyInterest() {
		double interest = calculateInterest();;
		balance = balance + interest; 
		System.out.printf("Interest amount %.2f is added to balance%n", interest);
		System.out.printf("Current Balance is: %.2f", balance);
	}
	

	
	public SavingsAccount(double balance) {
		super(balance);
		history = new StringBuilder();
	}
	
	public void deposit(double depositAmount) { 
//		if(depositAmount >= 0) {
			balance = balance + depositAmount;
			System.out.printf("Amount %.2f deposited%n",depositAmount);
			
				//apply interest
			 applyInterest();
		
//		else{ 
//			System.out.println("You cannot deposit a negative amount");
//		}
		super.deposit(depositAmount);
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		
		history.append("Deposit: ");
		history.append(formattedDate);
		history.append(": ");
		history.append(depositAmount);
		history.append("\n");
		
	}
	
	public void withdraw(double withdrawAmount) {
		//Checking that amount to be withdrawn cannot be more than blance, and cannot be negative
				if(withdrawAmount > 0) {
					if (withdrawAmount <= balance) {
						
						System.out.printf("Amount %.2f withdrawn%n",withdrawAmount);
						balance = balance - withdrawAmount;
						System.out.printf("Current Balance is: %.2f", balance);
						
					}
					
				}
				
				else{
					System.out.println("You cannot withdraw a negative amount");
				}
		super.withdraw(withdrawAmount);
		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MMM-yyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		
		history.append("withdrawal: ");
		history.append(formattedDate);
		history.append(": ");
		history.append(withdrawAmount);
		history.append("\n");
	}	
	public void printStatement() {
		System.out.println("Savings Account Statement");
		System.out.printf("\nCurrent balance = $%.02f\n", balance);
		System.out.println(history.toString());
	}
}
