import java.util.Scanner;




/**
* This program replicates a bank that has two types of account, savings and checkings.
* Both accounts have deposit and withdrawal methods and has history that records transactions  with dates and time as well
* @myAccount: a reference of the parent class BankAccount that either points to myCheckingAccount or mySavingsAccount based on users choice 
* @myCheckingAccount: is the Constructor that will store the balance for our checking account and has transaction fees.
* @mySavingsAccount: is the Constructor that will store the balance for our Savings account and has interest rate.
* @author Mark Ofosu, 
* @date 04/30/2021
*/

public class BankAccountTester {
	
	public static void main(String[] args) {	
//		BankAccount CheckingAccount;
		System.out.println("Welcome to MyBankAccount!");
		System.out.println("Enter your first Name to access your account");
		Scanner in = new Scanner(System.in);
		String customer = in.nextLine();
	
		BankAccount myAccount;
		System.out.printf("Hello %s, Enter an initial Checcking Account Balance\n", customer);
		double initialAmount = in.nextDouble();
		CheckingAccount myCheckingAccount = new CheckingAccount(initialAmount);
		System.out.printf("\nYour initial Checking Account balance is %.2f", myCheckingAccount.getBalance());
		
		System.out.printf("\nAlso, enter an initial Savings Account Balance\n", customer);
		double initialAmount2 = in.nextDouble();
		SavingsAccount mySavingsAccount = new SavingsAccount(initialAmount2);
		System.out.printf("\nYour initial Savings Account balance is %.2f", mySavingsAccount.getBalance());
		
		int accountType;
		do {
			System.out.println("\nChoose one of the account types to perform a transaction or enter 3 to Logout?");
			System.out.println("(1) CheckingAccount");
			System.out.println("(2) Saving");
			System.out.println("(3) Exit");
			accountType = in.nextInt();
			if (accountType !=3) {
				if (accountType == 1) {
					myAccount = myCheckingAccount;// reference to object of checking account
				}
				else {
					myAccount = mySavingsAccount;
				}
			
			double amount;
			

			int option;

				 option = TransactionMenu();
				if (option!=4 ) {
					if (option != 3) {// printStatement is exempted from this process
						System.out.println("Enter an amount: ");
					 	amount = in.nextDouble();
					 	if(amount < 0) { // force user to enter an amount greater than 0
					 		System.out.println("You cannot enter a negative amount");
					 	}
						makeTransaction(myAccount, option, amount);
						System.out.println("\n");
					}
					if (option == 3) { // if the option is 3, skip the rest of the process and just printStatement
						myAccount.printStatement();
					}	
				}
			
				else {// else user entered 4 to close checking or savings account
					System.out.println("Account is closed.");
					System.out.println("What else would you like to do?");
				}
			}
//			in.close();// close scanner
			
				
		} while (accountType !=3);
	
		System.out.println("Thank you for banking with us!");
		
	}
	/**
	 * transaction menu function to user
	 * @return transaction choice to be performed
	 */
	public static int TransactionMenu() {
		int option;
			System.out.println("\nWhat would you like to do?");
			System.out.println("(1) Withdraw");
			System.out.println("(2) Deposit");
			System.out.println("(3) Print Statement");
			System.out.println("(4) Exit");
			
	        Scanner scan = new Scanner(System.in);
			while (!scan.hasNextInt()) {// forces user to only enter choices 1, 2, 3, or 4
			    System.out.println("Input is not correct. Please enter 1, 2, 3, or 4.");
			    scan.nextLine();
			}
		    option = scan.nextInt();
		return option;
	}
	
	
	/**
	 * This method uses input from the user and perform the appropriate transaction
	 * @param myAccount points to either checking or savings 
	 * @param TransactionMenu user's choice of transaction
	 * @param amount amount to be withdrawn or deposited
	 */
	public static void makeTransaction(BankAccount myAccount, int TransactionMenu, double amount) {
		switch(TransactionMenu) {
		case 1:
			myAccount.withdraw(amount);
			break;
			
		case 2:
			myAccount.deposit(amount);
			break;
			
		case 3:
			myAccount.printStatement();	
		}
	}
}	


    		
