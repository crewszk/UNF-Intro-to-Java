import java.util.Scanner;

//No directions were given in the project file but
//using examples in class I was sure it was a program to find
//the area of a circle

public class MyCircle {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.printf("Enter the radius of the circle: ");
		double radius = input.nextDouble();
		
		System.out.printf("The area of the circle is: %10.2f\n", Math.PI * Math.pow(2, radius));
		
		input.close();
	}

}
