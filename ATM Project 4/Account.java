/* Name: Zackery Kyle Crews
 * Student ID: n00826481
 * Desctiption: This is a program that simulates an ATM that holds 10 accounts
 * It will prompt the user at start to enter an ID until one corresponding to an existing
 * account is entered, then a menu for that ID is shown. You can check the balance, withdraw
 * and deposit money, and exit the specific account to access another.
 */



import java.util.Random;
import java.util.Scanner;

public class Account {

	private int id = 0;
	private double balance = 0;
	
	//This is the no-args constructor method for the Account class that initializes
	//the two private data fields as 0
	Account()
	{
		this.id = 0;
		this.balance = 0;
	}
	
	//This is the constructor method for the Account class that initializes the two
	//private data fields as a user defined value
	Account(int id, int balance)
	{
		this.id = id;
		this.balance = balance;
	}
	
	//This is the accessor method for the id data field
	public int getId()
	{
		return this.id;
	}
	
	//This is the accessor method for the balance data field
	public double getBalance()
	{
		return this.balance;
	}
	
	//This is the mutator method for the id data field
	public void setId(int id)
	{
		this.id = id;
	}
	
	//This is the mutator method for the balance data field
	public void setBalance(double balance)
	{
		this.balance = balance;
	}
	
	//This is a method that takes a user defined amount to be withdrawn from the balance
	//data field, and if the amount is more than the balance, the action is ignored
	public void withdraw(double amount)
	{
		if(balance < amount)
		{
			System.out.println("You lack the funds for this withdrawl. Action ignored!");
		}
		else
		{
			this.balance -= amount;
			System.out.printf("Take your cash. Your current balance is $%.2f\n", this.balance);
		}
	}
	
	//This is a method that takes a user defined amount to be deposited into the balance
	//data field, and if the amount is negative, the action is ignored
	public void deposit(double amount)
	{
		if(amount < 0)
		{
			System.out.println("Amount entered is negative. Action Ignored!");
		}
		else
		{
			this.balance += amount;
			System.out.printf("$%.2f deposited. Your current balance is $%.2f\n", amount, this.balance);
		}
	}
}

class TestAccount {
	
	public static void main(String[] args) {
		
		//This stage initializes the accountIds and accounts arrays, and then inputs the values from
		//accountIds into the accounts objects, while also randomly generating a balance for each object
		Random rand = new Random();
		int[] accountIds = {9801, 2345, 3205, 1024, 4096, 6021, 8192, 5768, 7113, 1497};
		Account[] accounts = new Account[10];
		for(int i = 0; i < 10; i++)
		{
			accounts[i] = new Account();
			accounts[i].setId(accountIds[i]);
			accounts[i].setBalance((double)rand.nextInt(5001));
		}
		
		//After initialization, the ATM begins
		startATM(accountIds, accounts);
		
		
	}
	
	//Once the ATM begins it will start an infinite loop that prompts the user to input an ID
	//Which is will then check the validity of the ID with the checkID method. If a correct ID 
	//is entered, the printMenu method is accessed
	public static void startATM(int[] accountIds, Account[] accounts)
	{
		Scanner input = new Scanner(System.in);
		int id = 0, index = 0;
		
		do {
			System.out.println("****************** Welcome! Welcome! ******************");
			System.out.println("*******************************************************\n");
			System.out.print("Please enter a correct id: ");
			id = input.nextInt();
			index = checkId(id, accounts);
			if(index == -1)
			{
				System.out.println("This id doesn't exist, try again.");
				continue;
			}
			else
			{
				printMenu(accounts, index, input);
			}
		} while(true);
	}
	
	//Once a correct ID is entered, another loop starts for that specific account. A menu will be shown
	//and it will ask for the users input on what to do with that account. Once an input is entered,
	//based on the input an action will be done. Once the user is done with manipulating the specific
	//account and chooses to exit, it will return back to the startATM methods loop.
	public static void printMenu(Account[] accounts, int index, Scanner input)
	{
		int choice = 0;
		boolean exit = false;
		
		do {
		System.out.println("********************** Main Menu **********************");
		System.out.println("*******************************************************");
		System.out.println("\t\t1: check balance");
		System.out.println("\t\t2: withdraw");
		System.out.println("\t\t3: deposit");
		System.out.println("\t\t4: exit");
		System.out.print("\t\tEnter a choice: ");
		choice = input.nextInt();
		System.out.println("*******************************************************");
		switch(choice)
		{
			case 1: System.out.printf("The balance is\t$%.2f\n", accounts[index].getBalance());
					break;
			case 2: System.out.print("Enter an amount to withdraw: ");
					accounts[index].withdraw(input.nextDouble());
					break;
			case 3: System.out.print("Enter an amount to deposit: ");
					accounts[index].deposit(input.nextDouble());
					break;
			case 4: System.out.println("*********Thank you! Have a nice day! Good bye!*********");
					System.out.println("*******************************************************\n\n");
					exit = true;
					break;
			default: System.out.println("Invalid Input. Please retry.");
					break;
		}
		} while(exit == false);
	}
	
	//This method checks the validity of the account ID entered by the user, if one doesn't exist,
	//an index of -1 is returned, which is identified in the startATM loop as a failed search and prompts
	//the user to enter another ID
	public static int checkId(int id, Account[] accounts)
	{
		int index = -1;
		
		for(int i = 0; i < accounts.length; i++)
		{
			if(accounts[i].getId() == id)
			{
				index = i;
				break;
			}
		}
		
		return index;
	}
}


