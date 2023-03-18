//Module 3 Lesson 6: Decision-Making Statements

import java.util.Scanner;

public class F2Cif {
	public static void main(String[] args) {
		final int MIN_TEMP = 20;
		final int MAX_TEMP = 30;

		Scanner input = new Scanner(System.in);
		System.out.print("Enter a Fahrenheit value: ");
		int fahrenheit = input.nextInt();
		System.out.print("Enter a day of the week: ");
		String day = input.next();
		double celsius = (5.0/9) * (fahrenheit - 32);

		boolean raining = false;
		System.out.println(fahrenheit + " " + ((fahrenheit == 1) || (fahrenheit == -1) ? "degree" : "degrees"));

		System.out.printf("It's %.1f celsius outside on %s.\n", celsius, day);
		if (celsius >= MIN_TEMP && celsius < MAX_TEMP && !raining) {
			
			System.out.print("Is it rainy then? (y/n): ");
			String rainyAnswer = input.next().toLowerCase();
			if (rainyAnswer.startsWith("y")) {
				raining = true;
				System.out.println("Better to stay inside and study.");
			}
			else {
				System.out.println("That's warm enough for short sleeves (" + MIN_TEMP + "C), but not so hot that you should go shirtless (" + MAX_TEMP + "C)!");

			}
		}

		else {
			System.out.printf("%.1f degC is too extreme, stay inside and code\n", celsius);
			
		}
	}
}

/* Notes:

if (booleanExpression) statement;

if (booleanExpression)
	statement;

if (booleanExpression) {
	statement 1;
	statement 2; //braces are req'd for multiple statements
	statement 3;
}

relational operators <, >, >=, <=
equality operators ==, !=
logical operators
	AND	&&
	OR	||
	NOT	!

When an equality operatory is applied to a reference variable, Java checks if they're aliases (i.e. pointing to the same object). To compare character contents of strings, the String class includes the .equals(Object object) method.
e.g. x.equals(y)

String x = "park";
String y = "park";
x and y are aliases. Why? We did not use a new operator
	String x = "park" =/= String x = new String("park");

int ogString.compareTo(String anotherString);
int result = x.compareTo(y); //this compares unicode values starting at index 0


Precedence is roughly as follows:
	unary (!)
	multipiers
	additions
	relationals
	logicals
	assignment

short circuit evaluation: with && and ||, if the result is determined by the first condition, then Java does not bother evaluating the second.

ternary conditional operator: a short-hand for if-else
	condition ? expression1 : espression2 //kind of like the excel If statement
System.out.println(fahrenheit + " " + ((fahrenheit == 1) || (fharenheit == -1) ? "degree" : "degrees"));

mulit-way branching
	can be performed with if/else if/else or switch/case/default
	switch is nice for multiple specific cases because it's concise 
	switch will evaluate each branch regardless, so use break statements
	switch statements are considered less safe and cannot accommodate ranges

*/