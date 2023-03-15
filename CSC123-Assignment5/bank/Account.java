 //Nathan Poquiz (npoquiz1@toromail.csudh.edu)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.io.PrintWriter;
public class Account {
	//Fields
	
	private int accountNumber;
	private String type;
	private boolean accountOpen;
	private double balance;
	private Person accountHolder;
	private double overdraft;
	private ArrayList<String> statementList = new ArrayList<String>();
	private String statement;
	private int id = 0;
	
	//Constructor
	public Account(int accountNumber, String type, Person accountHolder, double overdraft) {
		this.accountNumber = accountNumber;
		this.type = type;
		this.accountHolder = accountHolder;
		this.overdraft = overdraft;
		accountOpen=true;
	}
	
	public void withdraw(double amount) {
		if (this.type.equals("Saving"))
		{
			if(this.balance-amount<0) 
			{
				try {
					balance();
				}
				catch(Exception e) {
					System.out.println("A problem occured: " + e);
				}
			}
			else if (!isOpen() && this.balance<0)
			{
				try {
					closed();
				}
				catch(Exception e) {
					System.out.println("A problem occured: " + e);
				}
			}
			else
			{
				this.balance=this.balance-amount;
				statement = String.format(id++ + " : Debit :%.2f", amount);
				statementList.add(statement);
			}
		}
		else if (this.type.equals("Checking"))
		{
			if ((this.balance-amount) < (0-this.overdraft))
			{
				try {
					balance();
				}
				catch(Exception e) {
					System.out.println("A problem occured: " + e);
				}
			}
			else if (!isOpen() && this.balance-amount<0)
			{
				try {
					closed();
				}
				catch(Exception e) {
					System.out.println("A problem occured: " + e);
				}
			}
			else
			{
				this.balance=this.balance-amount;
				statement = String.format(id++ + " : Debit :%.2f", amount);
				statementList.add(statement);
			}
		}
	}
	
	public void deposit(double amount) {
		if(amount<0)
		{
			System.out.printf("\nDeposit failed, the balance is: %.2f", balance);
		}
		else if (!isOpen() && this.balance>=0)
		{
			try {
				closed();
			}
			catch(Exception e) {
				System.out.println("A problem occured: " + e);
			}
		}
		else
		{
		this.balance=this.balance+amount;
		statement = String.format(id++ + " : Credit :%.2f", amount);
		statementList.add(statement);
		}
	}
	
	public boolean isOpen() {
		return this.accountOpen;
	}
	
	public void closeAccount() {
		this.accountOpen=false;
		System.out.printf("Account closed, current balance is %.2f, deposits are no longer possible", balance);
	}
	
	public double getBalance() {
		return this.balance;
	}
	
	public int getAccountNum() {
		return accountNumber;
	}
	
	public void statement()
	{
		for (int i = 0; i < statementList.size(); i++)
		{
			System.out.println(statementList.get(i));
		}
		System.out.printf("Balance: %.2f", balance);
	}
	
	public void save()
	{
		File targetFile = new File("C:/Users/Nathan P/CSC123/transactions.txt");
		PrintWriter writer = null;
		
		try {
			writer = new PrintWriter(targetFile);
			for (int i = 0; i < statementList.size(); i++)
			{
				writer.println(statementList.get(i));
			}
		}
		
		catch (FileNotFoundException e) {
			System.out.println("Error, file not found");
		} 
		 finally {
				if (writer != null)
				{
					writer.close();			
				}
		 }
	}
	
	public String toString() {
		return this.accountNumber+":"+type+":"+this.balance+":["+this.accountHolder.toString()+"]";
	}
	static void closed()throws AccountClosedException {
		throw new AccountClosedException("Error");
	}
	static void balance()throws InsufficientBalanceException {
		throw new InsufficientBalanceException("Error");
	}
}

