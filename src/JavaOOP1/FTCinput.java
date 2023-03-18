// Module 2 Lesson 5 - Input and Output

import java.util.Scanner;

public class FTCinput {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in); //read keyboard input
		System.out.print("Enter a Fahrenheit value and day of the week: ");
		int fahrenheit = input.nextInt();
		String day = input.nextLine().trim();
		double celsius = (5D/9) * (fahrenheit - 32);
		System.out.println("%s Fahrenheit: %f\n", day, fahrenheit);		
		System.out.printf("%s Celsius: %.1f\n", day, celsius);
	}
}


/* Notes:

Scanner input = new Scanner(System.in); //read keyboard input
<class type><object> = new <Class constructor>(<param>)

Scanner is not a built-in class. It needs to be imported

Classes can be grouped together as packages e.g. java.lang is a package that includes System, String, and many more. Something not in the java.lang package needs to be imported, such as Scanner, Timer, Stack.

	import packageName.memberName;
	import java.util.Scanner;
	import java.util.* //note: wildcards do not bloat programs. 
	May affect compile, does not affect runtime




*/