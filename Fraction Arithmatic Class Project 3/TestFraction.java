/* Name: Zackery Kyle Crews
 * Student ID: n00826481
 * Description: This program has the ability to create, and be able to manipulate, fractions
 * in the form of a Fraction object. The Fraction class is then tested in a TestFraction class.
 * Some of the operations are: Adding, subtracting, multiplying, and dividing two fractions and storing the
 * result into a new object, changing the numerator or denominator of a given fraction, print the entire fraction,
 * return the numerator or denominator to be manipulated in the program, as well as simplify the fraction.
 * 
 */

import java.util.Scanner;

class Fraction {

	private int numerator = 0;
	private int denominator = 1;
	
	//This is the Fraction default no-args constructor
	Fraction()
	{
	}
	
	//This is the Fraction constructor that creates the fraction using a numerator and denominator
	Fraction(int n, int d)
	{
		this.numerator = n;
		this.denominator = d;
	}
	
	//This returns the numerator of the given object
	public int getNumerator()
	{
		return this.numerator;
	}
	
	//This returns the denominator of the given object
	public int getDenominator()
	{
		return this.denominator;
	}
	
	//This changes the numerator of the given object
	public void setNumerator(int n)
	{
		this.numerator = n;
	}
	
	//This changes the denominator of the given object
	public void setDenominator(int d)
	{
		this.denominator = d;
	}
	
	//This prints the Fraction in a appropriate format
	public void printFraction()
	{
		System.out.println(this.numerator + "/" + this.denominator);
	}
	
	//This simplifies the given Fraction object into its reduced form
	public void reduceFraction()
	{		
		int gcd = gcd(this.numerator, this.denominator);
		
		this.numerator = (int)(this.numerator / gcd);
		this.denominator = (int)(this.denominator / gcd);
	}
	
	//This static method is used in the reduction process of simplifying a Fraction, and returns the greatest common denominator
	static int gcd(int a, int b)
	{
		int temp;
		
		do {
			temp = a;
			a = b;
			b = temp % b;			
		}while(b != 0);	
		
		return a;
	}
	
	//This takes a Fraction as an argument, and adds it to thisFraction, and then returns the result as a new Fraction object
	public Fraction addFraction(Fraction input)
	{
		Fraction result = new Fraction();
		int a = this.getNumerator(), b = this.getDenominator(), c = input.getNumerator(), d = input.getDenominator();
		
		System.out.printf("%d/%d + %d/%d = ", a, b, c, d);
		
		result.setNumerator((a * d) + (b * c));
		result.setDenominator(b * d);
		result.reduceFraction();
		
		result.printFraction();
		
		return result;
	}
	
	//This takes a Fraction as an argument, and subtracts it into thisFraction, and then returns the result as a new Fraction object
	public Fraction subtractFraction(Fraction input)
	{
		Fraction result = new Fraction();
		int a = this.getNumerator(), b = this.getDenominator(), c = input.getNumerator(), d = input.getDenominator();		
		System.out.printf("%d/%d - %d/%d = ", a, b, c, d);
		
		result.setNumerator((a * d) - (b * c));
		result.setDenominator(b * d);
		result.reduceFraction();
		
		result.printFraction();
		
		return result;
	}
	
	//This takes a Fraction as an argument, and multiplies it by thisFraction, and then returns the result as a new Fraction object
	public Fraction multiplyFraction(Fraction input)
	{
		Fraction result = new Fraction();
		int a = this.getNumerator(), b = this.getDenominator(), c = input.getNumerator(), d = input.getDenominator();
		System.out.printf("%d/%d * %d/%d = ", a, b, c, d);
		
		result.setNumerator(a * c);
		result.setDenominator(b * d);
		result.reduceFraction();
		
		result.printFraction();
		
		return result;
	}
	
	//This takes a Fraction as an argument, and divides it into thisFraction, and then returns the result as a new Fraction object
	public Fraction divideFraction(Fraction input)
	{
		Fraction result = new Fraction();
		int a = this.getNumerator(), b = this.getDenominator(), c = input.getNumerator(), d = input.getDenominator();
		System.out.printf("(%d/%d) / (%d/%d) = ", a, b, c, d);
		
		result.setNumerator(a * d);
		result.setDenominator(b * c);
		result.reduceFraction();
		
		result.printFraction();
		
		return result;
	}
}


public class TestFraction {

	public static void main(String[] args) {

		//This stage constructs using the default constructor Fraction object myFraction1 and an Scanner object for user input
		Scanner input = new Scanner(System.in);
		Fraction myFraction1 = new Fraction();
		
		//This stage receives user input for the numerator and denominator for myFraction1
		System.out.print("Please enter a numerator for myFraction1: ");
		myFraction1.setNumerator(input.nextInt());
		System.out.print("Please enter a denominator for myFraction1: ");
		myFraction1.setDenominator(input.nextInt());
		
		//This stage receives user input for the numerator and denominator for myFraction2, and then inputs those values
		//into the arguments of the constructor for the Fraction class
		System.out.print("Please enter a numerator for myFraction2: ");
		int myF2Num = input.nextInt();
		System.out.print("Please enter a denominator for myFraction2: ");
		int myF2Den = input.nextInt();
		Fraction myFraction2 = new Fraction(myF2Num, myF2Den);
		
		//This stage prints the two Fraction objects
		System.out.print("\nmyFraction1 is: ");
		myFraction1.printFraction();
		System.out.print("myFraction2 is: ");
		myFraction2.printFraction();
		
		//This stage prints the numerator and denominator seperately for the myFraction1 and myFraction2 object
		System.out.printf("\nThe numerator for myFraction1 is %d and the denominator is %d\n", myFraction1.getNumerator(), myFraction1.getDenominator());
		System.out.printf("The numerator for myFraction2 is %d and the denominator is %d\n\n", myFraction2.getNumerator(), myFraction2.getDenominator());
		
		//This stage utilizes the operation methods in the Fraction class by adding, subtracting, multiplying, and dividing
		//myFraction1 into myFraction2 and inputing the result into myFraction3
		Fraction myFraction3 = myFraction1.addFraction(myFraction2);
		myFraction3 = myFraction1.subtractFraction(myFraction2);
		myFraction3 = myFraction1.multiplyFraction(myFraction2);
		myFraction3 = myFraction1.divideFraction(myFraction2);
		
		input.close();
	}

}
