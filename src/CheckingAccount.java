import java.lang.StringBuilder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


/**
* 
* @CheckingAccount: is the Constructor that will store the balance for our checking account and has transaction fees.
* @balance: is the double number that will be used during the different transactions.
* @Deposit: will add a double entered by the user to be added to the constructor BankAccount.
* @Withdraw:will deduce an amount entere by the user provided that the user sill has funds in the constructor BankAccount.
* @author Mark Ofosu, Andres Cheung
* @date 04/23/2021
*/

public class CheckingAccount extends BankAccount {
	private double transactionFee;
	StringBuilder history;
	 
	
	/**
	 * default transaction fee
	 * initializing string builder - history
	 */
	public CheckingAccount() {
		transactionFee = 1.0;
		history = new StringBuilder();
	}
	

	

	/**
	 * Checking account initialization - parameter constructor
	 * Includes custom transaction fee and history to keep track of tratransactions
	 *
	 */
	public CheckingAccount(double balance) {
		super(balance);
		
		history = new StringBuilder();
	}
	
	/**
	 * Funtion to deposit an amount into account
	 * amount must be greater than 0
	 * apply transaction fee
	 * @param depositAmount amount to be deposited
	 * 
	 */
	public void deposit(double depositAmount) {
		double transactionFee = 1.0;
		if(depositAmount > 0) {
			balance = balance + depositAmount;
			System.out.printf("Amount %.2f deposited%n",depositAmount);
			
				//apply transaction fee
			balance = balance - transactionFee;
			System.out.printf("Transaction fee of %.2f is applied%n",transactionFee);
			System.out.printf("Current Balance is: %.2f", balance);
		}
		else{
			System.out.println("You cannot deposit a negative amount");
		}
		
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
		double transactionFee = 1.0;
		//Checking that amount to be withdrawn cannot be more than blance, and cannot be negative
		if(withdrawAmount + transactionFee < balance) {

				balance = balance - withdrawAmount;
				System.out.printf("Amount %.2f withdrawn%n",withdrawAmount);
				balance = balance - transactionFee;
				System.out.printf("Transaction fee of %.2f is applied%n",transactionFee);
				System.out.printf("Current Balance is: %.2f", balance);
		}
		else {
			System.out.println("You do not have enough balance in your account");
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
		System.out.println("Checking Account Statement");
		System.out.printf("\nCurrent balance$%.02f\n", balance);
		System.out.println(history.toString());
	}
	
}
