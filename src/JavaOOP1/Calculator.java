//Module 3 Homework: Calculator

import java.util.Scanner;

public class Calculator {
	public static void main(String[] args) {
		final String ERROR = "Invalid input entered. Terminating...";
		Scanner input = new Scanner(System.in);
		int op1 = 0;
		int op2 = 0;
		double dub1 = 0;
		double dub2 = 0;
		
		System.out.print("Choose an operation to perform (add, subtract, multiply, divide, alphabetize): ");
		String choice = input.next().toLowerCase();
		
		switch (choice) {
			case "add":
				System.out.print("Add two integers by inputing the values separated by a space (e.g. 5 6): ");
				if (input.hasNextInt()) {
					op1 = input.nextInt();
				}
				if (input.hasNextInt()) {
					op2 = input.nextInt();
				}
				else {
					System.out.println(ERROR);
					break;
				}
				System.out.println((op1 + op2));
				break;

			case "subtract":
				System.out.print("Subtract two integers by inputing the values separated by a space (e.g. 5 6): ");
				if (input.hasNextInt()) {
					op1 = input.nextInt();
				}
				if (input.hasNextInt()) {
					op2 = input.nextInt();
				}
				else {
					System.out.println(ERROR);
					break;
				}
				System.out.println((op1 - op2));
				break;

			case "multiply":
				System.out.print("Multiply two doubles by inputing the values separated by a space (e.g. 5.0 6.1): ");
				if (input.hasNextDouble()) {
					dub1 = input.nextDouble();
				}
				if (input.hasNextDouble()) {
					dub2 = input.nextDouble();
				}
				else {
					System.out.println(ERROR);
					break;
				}
				System.out.printf("%.2f\n", (dub1 * dub2));
				break;

			case "divide":
				System.out.print("Divide two doubles by inputing the values separated by a space (e.g. 5.4 6.14): ");
				if (input.hasNextDouble()) {
					dub1 = input.nextDouble();
				}
				if (input.hasNextDouble()) {
					dub2 = input.nextDouble();
					if (dub2 == 0) {
						System.out.println(ERROR);
						break;
					}
				}
				else {
					System.out.println(ERROR);
					break;
				}
				System.out.printf("%.2f\n", (dub1 / dub2));
				break;
			
			case "alphabetize":
				System.out.print("Input two words separated by a space : ");
				String word1 = input.next();
				String word2 = input.next();
				int lexResult = word1.compareToIgnoreCase(word2);
				if (lexResult == 0) {
					System.out.println("Chicken or Egg.");
				}
				else if (lexResult < 0) {
					System.out.println(word1 + " comes before " + word2);
				}
				else if (lexResult > 0) {
					System.out.println(word2 + " comes before " + word1);
				}
				break;

			default: System.out.println(ERROR);
		}

	}
}

/* Program requirements:
must have 1 swithc-case
must have 1 else-if
add & subtract take integers, multpily & divide take doubles
catch exceptions with error message
must use printf for multiply & divide output
*/
