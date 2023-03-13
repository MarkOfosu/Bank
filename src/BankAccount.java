

/**
 * This is class that contains methods for operating a bank account.
 * Uses BankAccount constructor to initialize the initial value of the constructor at 0.0.
 * @BankAccount: is the Constructor that will store the balance for our bank account.
 * @authors Mark Ofosu, Andres Cheung
 * @date 04/23/2021
 */
public abstract class BankAccount {
	public double balance;
	

/**
 * This initializes balance to 0.0
 */

	public BankAccount() {
		this.balance = 0.0;
		
	}
	
	/**
	 * accepts balance as an input into bank account and the resulting balnce becomes the new balance. 
	 * @param balance
	 */
	public BankAccount(double balance) {
		this.balance = balance;
	
	}
	/**
	 * Deposit adds up the depositAmount to the current balance
	 * @param depositAmount
	 */
	public void deposit(double depositAmount) {
		//check amount 
				if(depositAmount > 0) {
		balance = balance + depositAmount;
				}
				
	}
	/**
	 * Withdraw accepts an amount and deduct it form the current balce.
	 * @param withdrawAmount
	 */
	public void withdraw (double withdrawAmount) {
		balance = balance - withdrawAmount;
	}
	
	/**
	 * SetBalance keeps updating balance amount by making point to the current balance.
	 */
//	public void setBalance(double balance) {
//		this.balance = balance;
//	}
	
	/**
	 * getbalance get the balance.
	 * @return the current balance 
	 */
	
	public double getBalance() {
		return this.balance;
	}
	
	/**
	 * formats the output to a readable and friendly format.
	 * @return a formated output of balance.
	 */
	
	public abstract void printStatement();

	public String toString() {
		return String.format(" %.2f\n", this.balance);

	}
}