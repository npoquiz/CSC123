 //Nathan Poquiz (npoquiz1@toromail.csudh.edu)

import java.util.HashMap;

public class Bank {
	private static HashMap<Integer,Account> accounts = new HashMap<Integer,Account>();
	private static int accountNumbers=100;
	private Bank() {}
	
	public static Account openAccount(String firstName, String lastName, String SSN, String accountType, double overdraft) {
		Person customer=new Person(firstName, lastName,SSN);
		Account account=new Account(accountNumbers++, accountType, customer, overdraft);
		accounts.put(account.getAccountNum(), account);
		return account;

	}
	
		public static void printAccounts() {

			for (Account a : accounts.values()) {
				System.out.println(a);
			}
	}	
		
		public static Account findAccount(int accountNumber) {
			return accounts.get(accountNumber);
		}
	
    public static void deposit(int accountNumber, double amount) {
    	Account check = findAccount(accountNumber);	
    	if (check == null)
    	{
    		try {
				acc();
			}
			catch(Exception e) {
				System.out.println("A problem occured: " + e);
			}
    	}
    	else
    	{
    		check.deposit(amount);
    	}	
    }

	public static void withdraw(int accountNumber, double amount) {
    	Account check = findAccount(accountNumber);	
    	if (check == null)
    	{
    		try {
				acc();
			}
			catch(Exception e) {
				System.out.println("A problem occured: " + e);
			}
    	}
    	else
    	{
    		check.withdraw(amount);
    	}
    } 
     	
	public static void closeAccount(int accountNumber) {
    	Account check = findAccount(accountNumber);	
    	if (check == null)
    	{
    		try {
				acc();
			}
			catch(Exception e) {
				System.out.println("A problem occured: " + e);
			}
    	}
    	else
    	{
    		check.closeAccount();
    	}
    }
	
	public static void statement(int accountNumber)
	{
		Account check = findAccount(accountNumber);	
	  	if (check == null)
    	{
	  		try {
				acc();
			}
			catch(Exception e) {
				System.out.println("A problem occured: " + e);
			}
    	}
    	else
    	{
    		check.statement();
    	}
	}
	
	public static void save(int accountNumber)
	{
		Account check = findAccount(accountNumber);	
	  	if (check == null)
    	{
    		System.out.println("Account not found");
    	}
    	else
    	{
    		check.save();
    	}
	}
	static void acc()throws NoSuchAccountException {
		throw new NoSuchAccountException("Error");
	}
}