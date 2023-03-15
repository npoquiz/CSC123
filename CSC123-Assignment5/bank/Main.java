 //Nathan Poquiz (npoquiz1@toromail.csudh.edu)
import java.util.*;
public class Main {
	static Scanner keyboard = new Scanner(System.in);
	public static void main (String args[]) {
		
		int choice;
		Boolean quit = false;
		
		System.out.println("1 - Open a Checking account");
		System.out.println("2 - Open Saving Account");
		System.out.println("3 - List Accounts");
		System.out.println("4 - Account Statement");
		System.out.println("5 - Deposit funds");
		System.out.println("6 - Withdraw funds");
		System.out.println("7 - Close an account");
		System.out.println("8 - Save Transactions");
		System.out.println("9 - Exit");
		choice = keyboard.nextInt();
				
		while (!quit)
		{
			switch (choice) {
			case 1:
				checking();
				choice = 0;
				break;
			case 2:
				saving();
				choice = 0;
				break;
			case 3:
				list();
				choice = 0;
				break;
			case 4:
				statement();
				choice = 0;
				break;
			case 5:
				deposit();
				choice = 0;
				break;
			case 6:
				withdraw();
				choice = 0;
				break;
			case 7:
				close();
				choice = 0;
				break;
			case 8:
				save();
				choice = 0;
				break;
			case 9:
				quit = true;
				break;
			default:
				System.out.println("1 - Open a Checking account");
				System.out.println("2 - Open Saving Account");
				System.out.println("3 - List Accounts");
				System.out.println("4 - Account Statement");
				System.out.println("5 - Deposit funds");
				System.out.println("6 - Withdraw funds");
				System.out.println("7 - Close an account");
				System.out.println("8 - Save Transactions");
				System.out.println("9 - Exit");
				choice = keyboard.nextInt();
				break;
			}
		}
		
	}
	public static void checking() {
		keyboard.nextLine();
		System.out.println("Enter first name: ");
		String firstName = keyboard.nextLine();
		System.out.println("Enter last name: ");
		String lastName = keyboard.nextLine();
		System.out.println("Enter social security number: ");
		String SSN =  keyboard.nextLine();
		System.out.println("Enter overdraft limit: ");
		double overdraft = keyboard.nextDouble();
		Account test = Bank.openAccount(firstName, lastName, SSN, "Checking", overdraft);
		System.out.println("Thank you, the account number is: " + test.getAccountNum());
	}
	
	public static void saving() {
		keyboard.nextLine();
		System.out.println("Enter first name: ");
		String firstName = keyboard.nextLine();
		System.out.println("Enter last name: ");
		String lastName = keyboard.nextLine();
		System.out.println("Enter social security number: ");
		String SSN =  keyboard.nextLine();
		Account test = Bank.openAccount(firstName, lastName, SSN, "Saving", 0);
		System.out.println("Thank you, the account number is: " + test.getAccountNum());
	}
	
	public static void list() {
		Bank.printAccounts();
	}
	
	public static void statement() {
		System.out.println("Enter account number: ");
		int accountNumber = keyboard.nextInt();
		Bank.statement(accountNumber);
	}
	
	public static void deposit() {
		System.out.println("Enter account number: ");
		int accountNumber = keyboard.nextInt();
		System.out.println("Enter the amount to deposit: ");
		double amount = keyboard.nextInt();
		Bank.deposit(accountNumber, amount);
	}
	
	public static void withdraw() {
		System.out.println("Enter account number: ");
		int accountNumber = keyboard.nextInt();
		System.out.println("Enter the withdrawal amount: ");
		double amount = keyboard.nextInt();
		Bank.withdraw(accountNumber, amount);
	}
	
	public static void close() {
		System.out.println("Enter account number to close: ");
		int accountNumber = keyboard.nextInt();
		Bank.closeAccount(accountNumber);
	}
	
	public static void save() {
		System.out.println("Enter account number: ");
		int accountNumber = keyboard.nextInt();
		Bank.save(accountNumber);
	}
}
