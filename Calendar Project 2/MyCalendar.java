/* Name: Zackery Crews
 * ID#: N00826481
 * Assignment: Project #2
 * Description: This program generates a calendar for a user defined year.
 * Notes: I decided to completely compartmentalize the program in methods to save clutter in the main method.
 */


import java.util.Scanner;

public class MyCalendar {

	public static void main(String[] args) {
		
		int year, startDay;
		
		year = getYear();
		startDay = getStartDay(year);		
		printCalendar(year, startDay);		
	}
	
	//This method invokes the user to enter a year to generate the calendar for, while also keeping the user defined year within a given range	
	public static int getYear()
	{
		Scanner input = new Scanner(System.in);
		int year;
		boolean yearBool;
		
		do {
			System.out.printf("Please enter a year between 1780 and 2040: ");
			year = input.nextInt();
		
			if(year < 1780 || year > 2040)
			{
				System.out.println("This year was not within range. Please try again.\n");
				yearBool = false;
			}
			else
				yearBool = true;
		}while(yearBool == false);
		
		input.close();
		
		return year;
	}
	
	//This method generates and returns the starting day of January based on the given year
	public static int getStartDay(int year)
	{
		int startDay = (int)(28 + (year % 100) + (int)Math.floor(((year % 100) - 1) / 4.0) + Math.floor(year / 400) - (2 * Math.floor(year / 100))) % 7;
		if(startDay < 0)
			startDay += 7;
		
		return startDay;
	}
	
	//This method starts the printing process of the calendar, invoking both the getDaysAndMonthName and printDays method	
	public static void printCalendar(int year, int start)
	{
		String days = " Sun Mon Tue Wed Thu Fri Sat";
		String border = "-----------------------------";
		int numDays = 0;
		int startDay = start;
		
		for(int i = 1; i < 13; i++)
		{
			System.out.println(border);
			numDays = getDaysAndMonthName(i, year);
			System.out.println(year);
			System.out.println(days);
			startDay = printDays(startDay, numDays);
			System.out.println();
		}
		
		System.out.println(border);		
	}
	
	//This method will print the month name in a formatted output, while also determining how many days are in that given month, including determining if it is a leap year.
	public static int getDaysAndMonthName(int month, int year)
	{
		int numDays = 0;
		switch(month)
		{
		case 1: System.out.printf("%15s ", "January");
				numDays = 31;
				break;
		case 2: System.out.printf("%15s ", "February");
				if(year % 4 == 0)
					numDays = 29;
				else
					numDays = 28;
				break;
		case 3: System.out.printf("%15s ", "March");
				numDays = 31;
				break;
		case 4: System.out.printf("%15s ", "April");
				numDays = 30;
				break;
		case 5: System.out.printf("%15s ", "May");
				numDays = 31;
				break;
		case 6: System.out.printf("%15s ", "June");
				numDays = 30;
				break;
		case 7: System.out.printf("%15s ", "July");
				numDays = 31;
				break;
		case 8: System.out.printf("%15s ", "August");
				numDays = 31;
				break;
		case 9: System.out.printf("%15s ", "September");
				numDays = 30;
				break;
		case 10: System.out.printf("%15s ", "October");
				numDays = 31;
				break;
		case 11: System.out.printf("%15s ", "November");
				numDays = 30;
				break;
		case 12: System.out.printf("%15s ", "December");
				numDays = 31;
				break;
		default: System.out.print("ERROR ");
				numDays = 0;
				break;
		}
		
		return numDays;
	}

	//This method will print the main body of the calendar in the form of the days provided by the getDaysAndMonthName method as well as
	//printing and returning the starting day for each month in the proper format.
	public static int printDays(int start, int days)
	{
		int next = start;
		
		for(int k = 0; k < next; k++)
			System.out.print("    ");
		
		for(int i = 1; i < days + 1; i++)
		{
			System.out.printf("%4d", i);
			if(next < 7)
			{
				next++;
				if(next == 7)
				{
					next = 0;
					System.out.print("\n");
				}
			}
		}
		
		return next;
	}
}
