// A program that converts units F to units C. Mod 2 Less 1 - Mod 2 Less 3.

public class FahrenheitToCelsius {
	public static void main(String[] args) {
		int saturdayFahrenheit = 78;
		int sundayFahrenheit = 81;
		double saturdayCelsius = (5.0/9) * (saturdayFahrenheit - 32); //can also use 5D/9 to specify as a double instead of 5.0
		double sundayCelsius = (5.0/9) * (sundayFahrenheit - 32);
		final int TEST;
		TEST = 3; //doing the assignment on another line works with final
		System.out.println("Weekend Averages " + TEST);
		System.out.println("Saturday: " + saturdayCelsius);
		System.out.println("Sunday: " + sundayCelsius);
	}
}

/*
Notes:
Syntax vs semantics
	Syntax: Is the statement actually legal in Java?
	Semantics: What is it trying to achieve?

Compiler errors represent syntax violations, not semantics
Runtime errors occur at run, not at compile
Logical errors are not always caught by exceptions
	these can be minized by incremental testing and running

Variable's scope is the area in a program that it can be used in. Usually within the closest set of braces

"final" is a reserve word used to initialize a literal value e.g. final double PI = 3.14..

Primitive types:
byte: 8 bit signed int
short: 16 bit sighned int
int: 32 bit signed int
long: 64 bit signed int
float: 32 bit floating point
double: 64 bit floating point
char: individual characters
	chars should be thought of as a set, not a range, since the symbols are unordered
	a char literal is created with single quotes
	a double quote is used to enclose strings only
	an escape sequence can be used to mix the two:
		'\'' represents the char '
		all escape sequences start with \. Here are some others:
			\t is a tab
			\n is new line
			\r carriage return
			\\ is \
			\" is a double quote 
boolean: logical value

default int type is int, so an appended L is needed e.g. long BigNum = 9999999999L;

Expressions: a combination of operators, operands, or method calls in a single Java statement. The expression must evaluate to a single value.
	Arithmetic is a common application of an expression
	Mod (%) can be performed as on ints or floats, the sign of the operand carries.
	Division (/) of ints results in a truncated value

Mixed type expressions:
	promotion occurs when Java needs to match types of operands in an expression
	ints promote to floats; ints and floats promote to strings
	int<float/char/bool<string
Assignment conversion:
	conversion during a variable assignment vs within an expression
	e.g. int avg = 4; double gpa = avg;
	if you go double to int, an error will be thrown at compilation (possible loss of precision)
	generally, assignment conversion needs to flow from a smaller range to a larger range to be legal

Casting: explicit type conversion
	e.g. (double)5/9 instead of 5D/9
	cast has the highest precedence except for parentheses
	this can override the conversion error for precision loss e.g.:
	double avg = 4.0; int gpa = (int)avg; is a legal assignemnt
	casting is important in polymorphism (later concept)

*/
		